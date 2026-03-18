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
