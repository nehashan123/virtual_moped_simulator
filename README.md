#Virtual Moped Simulator

Simulation of driving a moped through a city grid using Java

## Project Structure
- `src/mopedpackage/Moped.java` – Core logic of the simulator (movement, fuel, location tracking).
- `src/mopedpackage/TestDrive.java` – Main entry point with `main()` method to start the simulation.
- `src/mopedpackagetests/MopedTest.java` – JUnit tests for key features.

- ## How to Run
- ### **Option 1: In Eclipse**
1. Import this project as a Java Project.
2. Open `TestDrive.java`.
3. Right-click → **Run As → Java Application**.

### **Option 2: Using Terminal**
1. Compile:
   ```bash
   javac -cp ".;lib/*" src/mopedpackage/*.java
