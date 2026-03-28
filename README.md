# 📐 Low-Level Design (LLD) Framework — #CERID

A structured approach to solving Low-Level Design problems in interviews and real-world systems.

---

## 🔑 What is #CERID?

**#CERID** is a step-by-step framework to design scalable, maintainable, and clean systems:

- **C — Clarify Requirements**
- **E — Entities**
- **R — Responsibilities**
- **I — Interactions**
- **D — Durability (Extensibility / Maintainability)**

---

## 🧠 1. Clarify Requirements (C)

Before jumping into design, fully understand the problem.

### ✅ Functional Requirements
What features should the system support?

**Example:**
- Create booking  
- Cancel booking  
- Process payment  

### ⚙️ Non-Functional Requirements
- Scalability  
- Performance  
- Availability  
- Consistency  

### ❓ Questions to Ask
- What are the constraints?  
- Expected scale?  
- Edge cases?  
- Real-time vs batch?  

---

## 🧱 2. Identify Entities (E)

Define the core objects (classes) in the system.

**Example:**
- User  
- Order  
- Payment  
- Product  

### 💡 Tips:
- Think in terms of real-world objects  
- Avoid over-engineering initially  
- Keep it minimal, refine later  

---

## 🎯 3. Define Responsibilities (R)

Assign clear responsibilities to each entity.

**Example:**
- `User` → manages profile, authentication  
- `Order` → handles order lifecycle  
- `Payment` → processes transactions  

### 🧩 Principles:
- Follow **Single Responsibility Principle (SRP)**  
- Avoid god classes  
- Keep logic modular  

---

## 🔄 4. Define Interactions (I)

Define how entities communicate with each other.

### Types of Interactions:
- Direct method calls  
- Service layer communication  
- Event-driven (async)  
- Interfaces / abstractions  

### Example Flow:
1. User places order  
2. Order service validates  
3. Payment service processes payment  
4. Notification service sends confirmation  

### 💡 Use:
- Interfaces for loose coupling  
- Design patterns (Strategy, Factory, Observer)  

---

## 🔧 5. Durability (D)

Ensure your design is flexible and easy to extend.

### Focus Areas:
- Extensibility  
- Maintainability  
- Testability  

### Techniques:
- Use interfaces and abstractions  
- Follow SOLID principles  
- Avoid tight coupling  
- Plug-and-play components  

### Example:
Adding a new payment method should **not break existing code**


## 🚀 Why Use #CERID?

- Keeps your thinking structured  
- Helps in interviews (clear communication)  
- Avoids missing critical aspects  
- Makes design scalable and clean  

---

## 🧠 Pro Tip

Don’t rush into coding.

- Spend **40–50%** time in **C + E**  
- Spend **30%** time in **R + I**  
- Polish with **D**  

---