# MouseDeliriumTremens

## Description
MouseDeliriumTremens is a lightweight utility that prevents your computer from entering sleep mode or activating the screensaver by simulating imperceptible mouse movement at regular intervals. This tool is particularly useful in environments where you have limited administrative privileges or restricted control over system settings.

## Features
- Simulates minimal mouse movement without visible displacement
- Prevents system sleep mode and screensaver activation
- Runs silently in the background
- Low resource consumption
- No administrative privileges required
- Configurable movement interval

## How It Works
The application works by:
1. Getting the current mouse cursor position
2. Making an imperceptible "movement" to the same position
3. Repeating this process at regular intervals
4. The movement is so minimal that it's unnoticeable to the user, yet sufficient to keep the system active

## Use Cases
- Working on computers with restricted administrative access
- Environments where system policies prevent changing power settings
- Maintaining system activity during long-running processes
- Keeping remote desktop connections active
- Preventing screen locks during presentations

## Requirements
- Windows operating system
- .NET Framework (version specified in project)
- No administrative privileges needed

## Disclaimer
This tool is intended for legitimate use cases where users need to maintain system activity. Please ensure you comply with your organization's policies regarding the use of such utilities.

## Note
This is a simple utility created for educational purposes and specific use cases where standard power management controls are not accessible. Use responsibly and in accordance with your workplace policies.

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
