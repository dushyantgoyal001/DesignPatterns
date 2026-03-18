# DesignPatterns

## Java: Packages, Directories & Classes (Simple Guide)

| Term | What it is |
|------|------------|
| **Class** | The actual code — a blueprint for objects. Lives in a `.java` file. |
| **Directory** | Where the file sits on your computer — a folder path like `CreationalDP/` or `com/example/`. |
| **Package** | A label at the top of the file that groups related classes. Must match the directory path. |

**In short:** The package says *“I belong to this group.”* The directory is where the file physically lives. They must match — if your package is `com.example`, your file goes in `com/example/`. Classes are the code inside those files.

## NotificationSystem — Factory Pattern

**Factory pattern** lets one place (the factory) create the right object based on a type. The client uses `new NotificationFactory()` and then `createNotification("EMAIL")` — it never uses `new EmailNotification()` or `new SMSNotification()`; the factory does that. Adding a new channel means one new class and one branch in the factory.

**In short:** You create the factory; the factory creates whatever concrete object it wants (based on what you ask for, e.g. `"EMAIL"`). You never instantiate `EmailNotification` or `SMSNotification` yourself — the factory decides which class to create and returns it. That’s the Factory pattern.

## ThemeFactory — Abstract Factory Pattern

**Abstract Factory** provides an interface for creating families of related objects (e.g. a whole UI theme) without specifying their concrete classes. Instead of one factory that creates one type of object (like Factory), you have one factory *per theme* that creates *all* the related widgets for that theme. The client code depends only on the abstract factory and product interfaces, so you can swap entire families (Mac vs Windows) without changing the client.

**How we implemented it:**

| Role | In this project |
|------|-----------------|
| **Abstract Factory** | `GUIFactory` — interface with `createButton()` and `createCheckBox()`. |
| **Concrete Factories** | `MacFactory`, `WindowsFactory` — each creates a full set of theme-consistent widgets. |
| **Abstract Products** | `Button`, `CheckBox` — interfaces for the widget types. |
| **Concrete Products** | `MacButton`, `MacCheckBox`, `WindowButton`, `WindowCheckBox` — theme-specific implementations. |
| **Client** | `Application` — takes a `GUIFactory` in its constructor and uses it to create button + checkbox; it never refers to Mac or Windows classes. |

You’ll see both themes: Mac-style and Windows-style button + checkbox, with the client unchanged — only the factory passed in changes.

**In short:** Abstract Factory gives you a “theme factory” that produces a whole family of related objects (e.g. button + checkbox). You pass one factory (Mac or Windows); the client stays the same and gets a consistent look. Adding a new theme = new factory + new product classes; the `Application` code stays untouched.

## DatabaseConnection — Singleton Pattern

**Singleton** ensures a class has only one instance and provides a global point of access to it. Useful for shared resources like a database connection, config, or thread pool — you want exactly one instance reused everywhere.

Singleton is about **how many instances (objects)** of the class exist in the whole application:

- Exactly one instance of that class ever exists.
- Everyone shares that same object (e.g. one `DatabaseConnection`).
- You get it via something like `getInstance()`; you don’t use `new` from outside.

So: **one object** of that class, not “one method” or “one use.”

**How we implemented it:**

| Part | In this project |
|------|----------------|
| **Single instance** | `private static volatile DatabaseConnection instance` — the one shared instance. |
| **No direct construction** | `private DatabaseConnection()` — only the class itself can create the object; others must use `getInstance()`. |
| **Global access** | `public static DatabaseConnection getInstance()` — returns the same instance every time. |
| **Thread safety** | *Double-checked locking*: check `instance == null` outside the lock (fast path), then `synchronized (DatabaseConnection.class)` and check again before creating. Only the first call creates; later calls avoid the lock when instance exists. |
| **Reflection guard** | In the constructor, `if (instance != null) throw ...` — prevents creating a second instance via reflection. |

**Why `volatile`?**

In double-checked locking, we use `volatile` on the `instance` field for two reasons:

1. **Visibility** — When one thread creates the instance inside the synchronized block, other threads might still see a cached “null” in their CPU cache. `volatile` forces reads and writes of `instance` to go to main memory, so once the first thread sets `instance`, every other thread sees the updated value.
2. **Ordering** — Without `volatile`, the JVM can reorder instructions: the reference might be assigned to `instance` before the object is fully constructed. Another thread could then see a non-null `instance` that isn’t fully initialized. `volatile` prevents this reordering so the object is fully built before it becomes visible.

So: **`volatile` makes the singleton instance safely visible across threads and ensures it is not seen until construction is complete.**

You’ll see one “Database Connection Created” and “Are both connections the same instance? true”.

**In short:** Singleton = one instance, private constructor, `getInstance()` for access. We use double-checked locking for thread-safe lazy creation and `volatile` so that instance is safely visible and fully initialized when other threads read it.
