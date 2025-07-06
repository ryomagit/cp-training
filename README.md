# Competitive Programming Practice

This repository contains my solutions and templates for practicing competitive programming using Java.  
I use this repository to prepare for contests, improve algorithm skills, and track my growth.

---

## 📁 Project Structure

cp-training/
├── .vscode/ # VSCode settings including launch.json
├── .mvn/ # Maven Wrapper
├── mvnw, mvnw.cmd # Maven Wrapper executables
├── pom.xml # Maven project configuration
├── make-problem.sh # Utility to generate new problem directories
├── src/
│ └── main/
│ └── java/
│ └── problems/
│ ├── A01/
│ │ ├── Main.java
│ │ └── input.txt
│ └── DebugLauncher.java

---

## 🚀 How to Run (via VSCode Debug)

1. Open the project folder in VSCode.
2. Press `F5` or select **Run and Debug → Debug Problem**.
3. Enter the problem name (e.g., `A01`, `compe/B`) when prompted.
4. Output appears in the terminal. Input will be read from `input.txt` if it exists.

> 💡 Logs like "input.txt を読み込みました" are sent to stderr and will not interfere with standard output.

---

## 🧪 How to Run (via CLI)

```bash
# Compile the project (only once unless source changes)
./mvnw compile

# Run a specific problem (e.g., A01)
./mvnw exec:java -Dexec.mainClass="problems.DebugLauncher" -Dexec.args="A01"
```
