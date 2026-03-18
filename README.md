# DesignPatterns

## Design Patterns — List by Priority (SDE2)

All major design patterns, ordered by how often they matter in SDE2 work (codebases, reviews, system design, interviews).

### Creational (how objects are created)

| Priority | Pattern | Why it matters for SDE2 |
|----------|---------|-------------------------|
| 1 | **Singleton** | One shared instance (DB pool, config, logger). Very common; know thread-safe variants. |
| 2 | **Factory Method / Simple Factory** | Centralized object creation by type; reduces `new` spread and simplifies adding new types. |
| 3 | **Builder** | Fluent APIs, optional params, immutable DTOs. Used in SDKs, config, and APIs. |
| 4 | **Abstract Factory** | Families of related objects (e.g. UI themes, platform abstractions). |
| 5 | **Prototype** | Clone existing instances instead of re-building. Less common but useful for caches/templates. |

### Structural (how objects are composed)

| Priority | Pattern | Why it matters for SDE2 |
|----------|---------|-------------------------|
| 1 | **Adapter** | Integrate legacy or third-party APIs without changing your core code. |
| 2 | **Decorator** | Add behavior without subclassing (streams, middleware, wrappers). |
| 3 | **Facade** | Simple API over a complex subsystem. Very common in services and SDKs. |
| 4 | **Proxy** | Lazy loading, access control, logging, remoting. |
| 5 | **Composite** | Tree structures (UI, file systems, expressions). |
| 6 | **Bridge** | Decouple abstraction from implementation. |
| 7 | **Flyweight** | Share state to save memory (e.g. repeated symbols, pooling). |

### Behavioral (how objects interact and assign responsibilities)

| Priority | Pattern | Why it matters for SDE2 |
|----------|---------|-------------------------|
| 1 | **Strategy** | Swap algorithms at runtime; keeps code open/closed. Very common. |
| 2 | **Observer** | Event-driven systems, pub/sub, reactive flows. |
| 3 | **Template Method** | Skeleton algorithm with pluggable steps (frameworks, pipelines). |
| 4 | **Command** | Encapsulate actions (undo/redo, queues, async jobs). |
| 5 | **Iterator** | Traverse collections without exposing structure. |
| 6 | **State** | Object behavior changes with internal state (FSMs, workflows). |
| 7 | **Chain of Responsibility** | Request through a chain of handlers (middleware, validation). |
| 8 | **Mediator** | Central coordinator for many components; reduces coupling. |
| 9 | **Memento** | Save/restore state (undo, snapshots). |
| 10 | **Visitor** | Add ops to a structure without changing its classes. |
| 11 | **Interpreter** | Interpret a language/DSL (less common day-to-day). |

**In this repo:** NotificationSystem (Factory), ThemeFactory (Abstract Factory), DatabaseConnection (Singleton), ObserverDesignPattern (Observer), Parkinglot (OOP/domain modeling).

---

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

You’ll see both themes: Mac-style and Windows-style button + checkbox, with the client unchanged — only the factory passed in changes.

**In short:** Abstract Factory gives you a “theme factory” that produces a whole family of related objects (e.g. button + checkbox). You pass one factory (Mac or Windows); the client stays the same and gets a consistent look. Adding a new theme = new factory + new product classes; the `Application` code stays untouched.

## DatabaseConnection — Singleton Pattern

**Singleton** ensures a class has only one instance and provides a global point of access to it. Useful for shared resources like a database connection, config, or thread pool — you want exactly one instance reused everywhere.

Singleton is about **how many instances (objects)** of the class exist in the whole application:

- Exactly one instance of that class ever exists.
- Everyone shares that same object (e.g. one `DatabaseConnection`).
- You get it via something like `getInstance()`; you don’t use `new` from outside.

So: **one object** of that class, not “one method” or “one use.”

**Why `volatile`?**

In double-checked locking, we use `volatile` on the `instance` field for two reasons:

1. **Visibility** — When one thread creates the instance inside the synchronized block, other threads might still see a cached “null” in their CPU cache. `volatile` forces reads and writes of `instance` to go to main memory, so once the first thread sets `instance`, every other thread sees the updated value.
2. **Ordering** — Without `volatile`, the JVM can reorder instructions: the reference might be assigned to `instance` before the object is fully constructed. Another thread could then see a non-null `instance` that isn’t fully initialized. `volatile` prevents this reordering so the object is fully built before it becomes visible.

So: **`volatile` makes the singleton instance safely visible across threads and ensures it is not seen until construction is complete.**

You’ll see one “Database Connection Created” and “Are both connections the same instance? true”.

**In short:** Singleton = one instance, private constructor, `getInstance()` for access. We use double-checked locking for thread-safe lazy creation and `volatile` so that instance is safely visible and fully initialized when other threads read it.

## ObserverDesignPattern — Observer Pattern

**Observer pattern** defines a one-to-many dependency: when the subject (e.g. a YouTube channel) changes state, all registered observers (subscribers) are notified automatically. The subject holds a list of observers and calls a notification method on each when something happens; observers implement a common interface (e.g. `notified(message)`). The subject does not need to know the concrete types of observers — only that they implement the `Observer` interface.

In this repo, `YoutubeChannel` implements `Subject` (register, remove, notify); `Subscriber` implements `Observer` (notified). The client registers subscribers with the channel and calls `notifyObservers("New video uploaded!")`; each subscriber receives the message. Adding a new kind of observer is just a new class implementing `Observer` and registering with the subject.

**In short:** One subject, many observers. Subject maintains a list of observers and notifies them when state changes. Observers implement a single interface (e.g. `notified(message)`). Keeps the subject decoupled from who is listening — event-driven and pub/sub style.
