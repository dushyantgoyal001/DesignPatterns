# DesignPatterns

## Design patterns — one line to remember

| Group | Pattern | Remember in one line |
|-------|---------|----------------------|
| **Creational** | Singleton | Only **one** shared object for the whole app (one key, one DB pool). |
| **Creational** | Factory | Tell the **counter** what you want; **they** build the right thing — you don’t `new` every variant yourself. |
| **Creational** | Builder | **Order form**: step-by-step options, then **build()** — no monster constructor. |
| **Creational** | Abstract Factory | **Meal deal** — one theme; a **matching set** of objects (swap the whole family). |
| **Creational** | Prototype | **Clone** a template instead of assembling from zero every time. |
| **Structural** | Adapter | **Travel plug** — translate old interface into what your app expects. |
| **Structural** | Decorator | **Wrap** the same thing; each layer **adds** behavior (milk on coffee). |
| **Structural** | Facade | **One simple button** hides a messy subsystem behind it. |
| **Structural** | Proxy | **Stand-in** in front of the real object (lazy load, guard, log). |
| **Structural** | Composite | **Tree**: treat **one leaf** and a **whole branch** the same way. |
| **Structural** | Bridge | Split **what** from **how** — two dimensions vary without subclass explosion. |
| **Structural** | Flyweight | **Share** the heavy repeated data; many objects, **few** copies in memory. |
| **Behavioral** | Strategy | **You plug in** *how* to do a job (UPI vs card) — same action, swap algorithm. |
| **Behavioral** | Observer | **Subscribe** — one event, **many listeners** get notified automatically. |
| **Behavioral** | Template Method | **Fixed recipe**, **variable steps** — framework calls your hooks. |
| **Behavioral** | Command | **Action as an object** — queue, log, **undo**; decouple button from work. |
| **Behavioral** | Iterator | Walk a collection with **next** without knowing its internal shape. |
| **Behavioral** | State | **Mode** decides behavior; object **transitions** itself (vending machine). |
| **Behavioral** | Chain of Responsibility | **Pass the request** along a line until someone **handles** it. |
| **Behavioral** | Mediator | **Hub** talks for everyone — components don’t all ping each other. |
| **Behavioral** | Memento | **Save / restore** a snapshot without breaking encapsulation (undo). |
| **Behavioral** | Visitor | **New operation** over a structure **without** changing every node class. |
| **Behavioral** | Interpreter | **Rules** for a small language — parse and evaluate step by step. |

**Reading tip:** Each pattern we implement in this repo also has a **Layman** block in its section — plain English first, then technical detail. Priority tables and full write-ups are below.

## When to apply — category & memory hint

| Category | Pattern | When to apply | Memory hint |
|----------|---------|---------------|-------------|
| Creational | Factory | When object creation logic should be hidden and the client should not know the concrete class | Creation problems |
| Creational | Abstract Factory | When creating families of related objects without specifying their concrete classes | Creation problems |
| Creational | Builder | When constructing a complex object step-by-step with many optional parameters | Creation problems |
| Creational | Singleton | When exactly one instance of a class must exist and be globally accessible | Creation problems |
| Creational | Prototype | When creating new objects by cloning an existing object is more efficient | Creation problems |
| Structural | Adapter | When two incompatible interfaces must work together | Structure problems |
| Structural | Bridge | When abstraction and implementation should vary independently | Structure problems |
| Structural | Composite | When individual objects and groups should be treated uniformly (tree structure) | Structure problems |
| Structural | Decorator | When behavior needs to be added dynamically without modifying the class | Structure problems |
| Structural | Facade | When a simplified interface is needed over a complex subsystem | Structure problems |
| Structural | Proxy | When an intermediary object controls access to another object | Structure problems |
| Behavioral | Strategy | When multiple algorithms exist and the algorithm should be chosen at runtime | Communication / behavior problems |
| Behavioral | Observer | When one object change should notify multiple dependent objects | Communication / behavior problems |
| Behavioral | Command | When requests should be encapsulated as objects to allow parameterization and queuing | Communication / behavior problems |
| Behavioral | Mediator | When interactions between many objects should be centralized | Communication / behavior problems |
| Behavioral | Template Method | When defining a skeleton of an algorithm but allowing subclasses to override steps | Communication / behavior problems |
| Behavioral | Chain of Responsibility | When multiple handlers can process a request and handler is decided at runtime | Communication / behavior problems |
| Behavioral | State | When an object changes behavior based on its internal state | Communication / behavior problems |
| Behavioral | Iterator | When traversing elements of a collection without exposing internal structure | Communication / behavior problems |
| Behavioral | Visitor | When adding new operations to existing object structures without modifying them | Communication / behavior problems |
| Behavioral | Memento | When capturing and restoring an object's state | Communication / behavior problems |
| Behavioral | Interpreter | When defining and evaluating grammar or language expressions | Communication / behavior problems |

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

**In this repo:** NotificationSystem (Factory), ThemeFactory (Abstract Factory), DatabaseConnection (Singleton), BuilderDesignPattern (Builder), AdapterDesignPattern (Adapter), DecoratorDesignPattern (Decorator), StrategyPattern (Strategy), StateDesignPattern (State), ObserverDesignPattern (Observer), Parkinglot (OOP/domain modeling).

> **Quick ref:** One-line memory hooks for every pattern are in **Design patterns — one line to remember** at the top of this file.

---

## Java: Packages, Directories & Classes (Simple Guide)

**Layman:** A **class** is the recipe; the **folder on disk** is where the file lives; the **package** is the label on the box — and the label must match the shelf (folder path) so Java can find it.

| Term | What it is |
|------|------------|
| **Class** | The actual code — a blueprint for objects. Lives in a `.java` file. |
| **Directory** | Where the file sits on your computer — a folder path like `CreationalDP/` or `com/example/`. |
| **Package** | A label at the top of the file that groups related classes. Must match the directory path. |

**In short:** The package says *“I belong to this group.”* The directory is where the file physically lives. They must match — if your package is `com.example`, your file goes in `com/example/`. Classes are the code inside those files.

## NotificationSystem — Factory Pattern

**Layman:** You don’t walk into the kitchen and grab ingredients yourself. You tell the **counter** “I want email” or “I want SMS,” and **they** hand you the right thing. You only know “notification”; you don’t care which exact class was made behind the counter.

**Factory pattern** lets one place (the factory) create the right object based on a type. The client uses `new NotificationFactory()` and then `createNotification("EMAIL")` — it never uses `new EmailNotification()` or `new SMSNotification()`; the factory does that. Adding a new channel means one new class and one branch in the factory.

**In short:** You create the factory; the factory creates whatever concrete object it wants (based on what you ask for, e.g. `"EMAIL"`). You never instantiate `EmailNotification` or `SMSNotification` yourself — the factory decides which class to create and returns it. That’s the Factory pattern.

**Remember:** *One order window — they pick the product for you.*

## ThemeFactory — Abstract Factory Pattern

**Layman:** Instead of ordering **one** item, you order a **meal deal**: everything matches — Mac look **or** Windows look (button + checkbox together). Swap the **whole meal** by swapping which factory you use; you don’t mix Mac button with Windows checkbox.

**Abstract Factory** provides an interface for creating families of related objects (e.g. a whole UI theme) without specifying their concrete classes. Instead of one factory that creates one type of object (like Factory), you have one factory *per theme* that creates *all* the related widgets for that theme. The client code depends only on the abstract factory and product interfaces, so you can swap entire families (Mac vs Windows) without changing the client.

You’ll see both themes: Mac-style and Windows-style button + checkbox, with the client unchanged — only the factory passed in changes.

**In short:** Abstract Factory gives you a “theme factory” that produces a whole family of related objects (e.g. button + checkbox). You pass one factory (Mac or Windows); the client stays the same and gets a consistent look. Adding a new theme = new factory + new product classes; the `Application` code stays untouched.

**Remember:** *One factory = one full matching set — not random mix-and-match.*

## DatabaseConnection — Singleton Pattern

**Layman:** There is **only one** shared “thing” for the whole app — like **one** office coffee machine or **one** building key everyone uses. Nobody makes a second copy; everyone asks for **the same** instance (e.g. `getInstance()`).

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

**Remember:** *Only one object — everyone shares it.*

## BuilderDesignPattern — Builder Pattern

**Layman:** Building a pizza (or any object with many options) is like filling out an **order form**: you **start** with what you must pick (here: **crust** and **sauce**), then **optionally** add lines for topping, extra cheese, gluten-free — only what you care about. When you’re done, you say **“build it”** (`build()`) and you get **one finished `Pizza`**. No giant “remember argument 3 vs 4” constructor every time.

**Builder pattern** separates **step-by-step construction** from the **final object**. `pizzaBuilder` holds the choices; each `set…` method adds a piece and returns `this` so you can **chain** calls. `build()` creates the immutable `Pizza` with all fields set. Skip any optional step if you don’t need it (see `plainorder` in `Main` — only crust + sauce, then `build()`).

In this repo: `Pizza` is the product (all `final` fields). `Pizza.pizzaBuilder` is the builder — crust/sauce fixed at start; topping and flags are optional setters; `build()` returns `new Pizza(...)`.

**In short:** Builder = **fluent, readable assembly** of a complex object; **required stuff** up front, **optional** via chained setters, **one** `build()` at the end.

**Remember:** *Order form → tick boxes → hand in → get the meal.*

## DecoratorDesignPattern — Decorator Pattern

**Layman:** You start with **plain coffee**. Want milk? You don’t rewrite the coffee recipe — you **wrap** the cup: “this is still coffee, but now with milk.” Want sugar too? **Wrap again** around what you already had. Each **layer** adds a name and a price. Like **nested sleeves** on a drink: same drink inside, extras on the outside — and you can mix **order** (milk then sugar, or the other way) by how you wrap.

**Decorator pattern** adds responsibilities to an object **dynamically** by wrapping it in objects that share the same interface (`Coffee`). Each decorator holds a reference to the **inner** `Coffee`, delegates to it, and **extends** `getDescription()` / `getCost()` (or other behavior). The client always talks to `Coffee`; it doesn’t need to know how many decorators are stacked.

In this repo: `SimpleCoffe` is the **component**. `CoffeeDecorator` is the **base wrapper** (implements `Coffee`, forwards to `decoratedCoffee`). `MilkDecorator` and `SugarDecorator` add “, Milk” / “, Sugar” and bump the cost. `Main` builds `new SimpleCoffe()` → `new MilkDecorator(coffee)` → `new SugarDecorator(coffee)` — **composition at runtime**, no explosion of subclasses like `CoffeeWithMilkAndSugar`.

**In short:** Decorator = **wrap** the same interface, **add** behavior outward; stack wrappers; **open for extension**, **closed** for editing the core class.

**Remember:** *Russian dolls / coffee add-ons — wrap, don’t rewrite the base.*

## AdapterDesignPattern — Adapter Pattern

**Layman:** Your **new travel app** only speaks **JSON** (“give me weather like this”). The **old weather service** only answers in **XML** — different “plug shape.” You don’t throw away the old box. You use a **travel adapter**: same old device inside, but the **socket your app uses** now fits. The app asks for JSON; the adapter calls the legacy code, **translates** XML → JSON, and returns what the app expects.

**Adapter pattern** lets classes with **incompatible interfaces** work together. You define what the **client** needs (`WeatherTarget` with `getWeatherDataInJson()`). The **adaptee** is the existing class (`LegacyWeatherService` with `fetchWeatherData()` returning XML). The **adapter** (`WeatherAdapter`) implements `WeatherTarget`, holds a `LegacyWeatherService`, calls `fetchWeatherData()`, converts (here `convertXmlToJson`), and returns JSON. The client depends only on `WeatherTarget`, not on XML details.

In this repo: `TravelApp` builds `LegacyWeatherService`, wraps it in `WeatherAdapter`, and uses `WeatherTarget` — the app stays on the **new** contract while the **old** service stays untouched.

**In short:** Adapter = **translate / wrap** an existing component so it **fits** the interface your code (or API) already expects — **integration without rewriting** the legacy class.

**Remember:** *Power plug adapter — old device, new socket; translator in the middle.*

## Comparison: Adapter vs Decorator

| | **Adapter** | **Decorator** |
|---|-------------|---------------|
| **Interface** | **Changes** the surface so something **incompatible** can work with what the client expects (e.g. XML service → JSON-shaped API). | **Keeps** the **same** interface as the object inside; you still talk to `Coffee`, but with **extra** behavior layered on. |
| **Goal** | **Make it compatible** — “translate the plug.” | **Add responsibilities** — “same drink, more toppings.” |
| **In this repo** | `WeatherAdapter` implements `WeatherTarget`; client never calls `fetchWeatherData()` directly. | `MilkDecorator` / `SugarDecorator` still **are** `Coffee`; they extend description and cost. |

**One line:** **Adapter** = new **face** for an old thing so callers don’t have to change *their* contract. **Decorator** = same **face**, **richer** behavior behind it.

## StrategyPattern — Strategy Pattern

**Layman:** At checkout, the **cart** always does “take payment,” but **you** pick **how**: pay with **UPI** or **credit card**. The cart doesn’t need a giant `if (UPI) … else if (card) …`. You **plug in** the payment style you want; same button (“checkout”), different **method** behind it. It’s about **how to do** one job (pay), not about the cart “becoming a different person.”

**Strategy pattern** defines a family of algorithms (e.g. payment methods), encapsulates each one, and makes them **interchangeable**. The **context** (`ShoppingCart`) holds a `PaymentStrategy` reference and delegates `checkout` to `paymentStrategy.pay(amount)`. The **client** (`Main`) chooses which concrete strategy to inject via `setPaymentStrategy` — swap at runtime without changing `ShoppingCart`.

In this repo: `PaymentStrategy` is the strategy interface (`pay`). `UPIpaymentStrategy` and `CCPaymentStrategy` are concrete strategies (different rules, e.g. card adds a fee in the demo). `ShoppingCart` stays stable; new payment type = new class implementing `PaymentStrategy`.

**In short:** Strategy = **pluggable algorithms**; context delegates; **client** (or config) **picks which strategy** — **how** to perform a task, **open/closed** for new behaviors.

**Remember:** *Checkout is fixed — payment “how” is swappable.*

## StateDesignPattern — State Pattern

**Layman:** A **vending machine** acts differently depending on **what situation it’s in**: **no money** vs **has money**. Same three buttons (insert / eject / dispense), but **what happens** depends on **which mode** the machine is in right now. When you insert a coin, the machine **switches mode** to “has money.” When you take the item or eject, it **switches back** to “no money.” The machine **decides** those transitions as events happen — not the customer picking a “strategy” from a menu.

**State pattern** models this as a **context** (`VendingMachineMain`) that holds a **`currentState`** reference. All states implement the same interface (`VendingMachin`: `insertMoney`, `ejectMoney`, `pushButton`). The context **delegates** every action to `currentState`. Each concrete state (`NoMoneyState`, `HasMoneyState`) implements those methods for **its** situation and, when rules say so, calls **`machine.setState(...)`** to move to another state (reusing the **same** state object instances stored on the context — `getNoMoneyState()` / `getHasMoneyState()`).

In this repo: `Main` only talks to `VendingMachineMain`. The machine starts in `NoMoneyState`. `insertMoney` prints and transitions to `HasMoneyState`. From there, `ejectMoney` or `pushButton` prints and transitions back to `NoMoneyState`. No giant `if (hasMoney)` in the context — behavior lives in the **state classes**.

**In short:** State = **object’s mode** drives behavior; **context delegates**; states **transition** the context via `setState` — **who I am right now**, not “client picks an algorithm.”

**Remember:** *Same buttons, different rules per mode — the machine updates its own mode.*

## Comparison: Strategy vs State

| | **Strategy** | **State** |
|---|--------------|-----------|
| **Who chooses** | The **client** (or caller) usually **injects** or **sets** which strategy to use — explicit choice of **how** to behave. | The **object** often **transitions** its own internal state; behavior follows **who it is right now** (e.g. draft → published). |
| **Focus** | **How to do a task** — interchangeable algorithms for the **same operation** (e.g. pay via UPI vs card). | **Who I am right now** — the object’s **mode** or **phase** drives which behavior runs (like a traffic light: red vs green). |
| **Typical mental model** | “Pick a tool for this job.” | “I’m in state X, so I act like X until I transition.” |
| **In this repo** | `Main` calls `setPaymentStrategy(new UPIpaymentStrategy())` then later `new CCPaymentStrategy()` — **you** switch **how** checkout pays. | `VendingMachineMain` holds `currentState`; `NoMoneyState` / `HasMoneyState` call `setState(...)` after actions — the **machine’s mode** changes as you use it. |

**One line:** **Strategy** = **you** choose **how** to do something. **State** = the object’s **current identity/mode** decides behavior until it **changes itself**.

## ObserverDesignPattern — Observer Pattern

**Layman:** A **YouTube channel** doesn’t call each fan by name. People hit **Subscribe**; the channel keeps a **list**. When something happens (“new video!”), the channel **broadcasts** one message and **everyone on the list** gets it. Fans don’t poll the channel every minute — the channel **pushes** updates.

**Observer pattern** defines a one-to-many dependency: when the subject (e.g. a YouTube channel) changes state, all registered observers (subscribers) are notified automatically. The subject holds a list of observers and calls a notification method on each when something happens; observers implement a common interface (e.g. `notified(message)`). The subject does not need to know the concrete types of observers — only that they implement the `Observer` interface.

In this repo, `YoutubeChannel` implements `Subject` (register, remove, notify); `Subscriber` implements `Observer` (notified). The client registers subscribers with the channel and calls `notifyObservers("New video uploaded!")`; each subscriber receives the message. Adding a new kind of observer is just a new class implementing `Observer` and registering with the subject.

**In short:** One subject, many observers. Subject maintains a list of observers and notifies them when state changes. Observers implement a single interface (e.g. `notified(message)`). Keeps the subject decoupled from who is listening — event-driven and pub/sub style.

**Remember:** *Subscribe once — get told when something changes.*
