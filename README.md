# RetroNotes 2003

<img src="retronotes.png" width = 50%>

**Author: uxokpro1234**

A retro-style desktop note manager inspired by early 2000s Windows utility software.

Built in Java using Swing with a classic Windows XP / old desktop utility aesthetic.
<br>
---

## Features

- Classic utility software aesthetic
- Retro Windows-style UI
- Status bar updates 
- Create notes  
- Edit existing notes  
- Delete notes  
- System log panel  
- Toolbar buttons  

---

## UI Style

RetroNotes 2003 is intentionally designed to resemble:

- Windows XP utilities  
- Early 2000s productivity software  
- Classic Java Swing applications  
- Old desktop organizer tools  
- Retro system utilities  

The project deliberately avoids modern flat UI design in favor of a nostalgic desktop feel.

---

## Technologies Used

- Java 21  
- Java Swing  
- Object-Oriented Programming (OOP)  
- Event-driven GUI architecture
- 
---

## Architecture


GUI Layer
↓
NoteManager
↓
ArrayList<Note>


The application cleanly separates:

- UI rendering  
- Note management logic  
- Data storage objects  

---

## Current Features

- Dynamic note creation  
- Title/content synchronization  
- Note selection system  
- Editable note storage  
- Retro toolbar system  
- Logging console  

---

## Planned Features

- File saving/loading  
- SQLite support  
- Export to `.txt`  
- Search system  
- Multiple themes  
- Startup splash screen  
- Keyboard shortcuts  

---

## Build
To build from source, follow these steps:

- Open a terminal and clone the repository using git clone https://github.com/uxokpro1234/RetroNotes-2003.
- Go into this directory using cd <location of cloned repo>.
- Run ./gradlew build on linux or macos or gradlew build on windows.
- Get the mod file from the /build/libs folder.
