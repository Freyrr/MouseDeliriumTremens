# MouseDeliriumTremens

## Description
MouseDeliriumTremens is a lightweight utility that prevents your computer from entering sleep mode or activating the screensaver by simulating imperceptible mouse movement at regular intervals. This tool is particularly useful in environments where you have limited administrative privileges or restricted control over system settings.

## Features
- Simulates minimal mouse movement with imperceptible oscillation (±1 pixel)
- Prevents system sleep mode and screensaver activation
- Runs silently in the background (no visible windows)
- Low resource consumption
- Configurable movement interval and active hours
- Screen boundary detection to prevent cursor from going off-screen
- Single instance enforcement (prevents multiple copies from running)
- Windows executable (EXE) available for easy deployment

## How It Works
The application works by:
1. Getting the current mouse cursor position
2. Moving the mouse by 1 pixel vertically in alternating directions (+1/-1)
3. Repeating this process at configurable intervals (default: 2 minutes)
4. Operates 24/7 by default (configurable to specific hours)
5. The oscillating movement prevents reaching screen edges and is barely noticeable to the user

## Use Cases
- Working on computers with restricted administrative access
- Environments where system policies prevent changing power settings
- Maintaining system activity during long-running processes
- Keeping remote desktop connections active
- Preventing screen locks during presentations
- Automated systems that need to stay active

## Requirements
- Java Runtime Environment (JRE 8 or higher)
- Works on Windows, macOS, and Linux
- No administrative privileges needed for basic operation

## Installation

### Option 1: Windows Executable (Recommended for Windows)
1. Download `MouseDeliriumTremens.exe` from the `launch4j_config` folder
2. Place it in a convenient location
3. Double-click to run, or configure with Task Scheduler for automatic startup

### Option 2: JAR File (Cross-platform)
1. Ensure Java 8 or higher is installed
2. Download `MouseDeliriumTremens-0.0.1-SNAPSHOT.jar` from the `target` folder
3. Run with: `java -jar MouseDeliriumTremens-0.0.1-SNAPSHOT.jar`

## Building from Source

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Apache Maven 3.x

### Build Steps
```bash
# Clone the repository
git clone <repository-url>
cd MouseDeliriumTremens

# Build with Maven
mvn clean package

# The JAR will be created in target/MouseDeliriumTremens-0.0.1-SNAPSHOT.jar
```

### Creating Windows Executable
1. Install [Launch4j](https://launch4j.sourceforge.net/)
2. Open Launch4j and load `launch4j_config/launch4j_config_file.xml`
3. Click the Build button (gear icon)
4. The EXE will be created in `launch4j_config/MouseDeliriumTremens.exe`

See `CONFIGURATION_LAUNCH4J.md` for detailed instructions.

## Configuration

The application supports runtime configuration via Java system properties:

### Movement Interval
```bash
# Set interval to 120 seconds (2 minutes)
java -Dmouse.sleep.millis=120000 -jar MouseDeliriumTremens-0.0.1-SNAPSHOT.jar
```

### Active Hours
```bash
# Active from 8 AM to 6 PM
java -Dmouse.start.hour=8 -Dmouse.end.hour=18 -jar MouseDeliriumTremens-0.0.1-SNAPSHOT.jar
```

### Combined Configuration
```bash
java -Dmouse.sleep.millis=120000 -Dmouse.start.hour=0 -Dmouse.end.hour=23 -jar MouseDeliriumTremens-0.0.1-SNAPSHOT.jar
```

### Default Values
- **Interval**: 120000 ms (2 minutes)
- **Start Hour**: 0 (midnight)
- **End Hour**: 23 (11 PM)

## Windows Task Scheduler Setup

To run automatically at system startup:

1. Open Task Scheduler (`taskschd.msc`)
2. Create a new task (not basic task)
3. Configure:
   - **General**: "Run whether user is logged on or not"
   - **Triggers**: "At startup"
   - **Actions**: Start program → `MouseDeliriumTremens.exe`
   - **Conditions**: Uncheck "Start only if on AC power"
   - **Settings**: Uncheck "Stop the task if it runs longer than"

See `TASK_SCHEDULER_SETUP.md` for detailed step-by-step instructions.

## Running Hidden on Windows

The Windows EXE is configured to run without showing any windows (GUI header type). 

For JAR files, use `javaw.exe` instead of `java.exe`:
```cmd
javaw -jar MouseDeliriumTremens-0.0.1-SNAPSHOT.jar
```

## Stopping the Application

### Windows
```powershell
# Stop the EXE
taskkill /F /IM MouseDeliriumTremens.exe

# Or stop the Java process
taskkill /F /IM javaw.exe
```

### Linux/macOS
```bash
# Find the process
ps aux | grep MouseDeliriumTremens

# Kill the process
kill <PID>
```

## Documentation

- `CONFIGURATION.md` - Detailed configuration options
- `CONFIGURATION_LAUNCH4J.md` - Step-by-step Launch4j guide
- `DEPLOYMENT_GUIDE.md` - Windows deployment and distribution
- `TASK_SCHEDULER_SETUP.md` - Task Scheduler configuration
- `TROUBLESHOOTING.md` - Common issues and solutions

## Disclaimer
This tool is intended for legitimate use cases where users need to maintain system activity. Please ensure you comply with your organization's policies regarding the use of such utilities.

## Note
This is a utility created for specific use cases where standard power management controls are not accessible. Use responsibly and in accordance with your workplace policies.

## License
MIT License

Copyright (c) 2025

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
