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
