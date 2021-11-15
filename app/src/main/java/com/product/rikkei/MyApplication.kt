package com.product.rikkei

import android.app.Application
import com.product.rikkei.models.Shortcut

class MyApplication : Application() {
    val categories by lazy {
        mutableListOf(
            "General",
            "GNOME",
            "KDE",
            "Xfce",
            "LXDE",
            "Cinnamon",
            "Bash",
            "Ubuntu",
            "Firefox",
            "ChromeOS",
        )
    }

    val generalShortcuts by lazy {
        mutableListOf<Shortcut>(
            Shortcut("Ctrl + C", "Copy any highlighted text, image, or some other object to the clipboard."),
            Shortcut("Ctrl + V", "Paste copied text, image, or some other object from the clipboard."),
            Shortcut("Ctrl + X", "Cut highlighted text, image, or some other object."),
            Shortcut("Ctrl + S", "Save the currently opened file."),
            Shortcut("Ctrl + N", "Create a new file."),
            Shortcut("Ctrl + Z", "Undo the last action."),
            Shortcut("Ctrl + Q", "Quit the application in focus."),
            Shortcut("Ctrl + Alt + F1 to F6", "Switch to a virtual console."),
            Shortcut("Ctrl + Alt + F7", "Switch to the first graphical terminal."),
        )
    }

    val gnomeShortcuts by lazy {
        mutableListOf<Shortcut>(
            Shortcut("Super", "Enter the Activities Overview."),
            Shortcut("Alt + Tab", "Cycle between running applications."),
            Shortcut("Alt + Shift + Tab", "Cycle between running applications in the opposite direction."),
            Shortcut("Alt + ` (grave accent)", "Cycle between windows of the same application in Alt + Tab."),
            Shortcut("Alt + F1", "Open the Applications menu."),
            Shortcut("Alt + F2", "Open a floating command prompt."),
            Shortcut("PrtSc", "Take a screenshot of the entire screen."),
            Shortcut("Alt + PrtSc", "Take a screenshot of the window in focus."),
            Shortcut("Ctrl + Alt + Arrow keys", "Switch between workspaces."),
            Shortcut("Ctrl + Alt + D", "Minimize all windows to show desktop."),
        )
    }

    val kdeShortcuts by lazy {
        mutableListOf<Shortcut>(
            Shortcut("Super", "Open the Application Launcher."),
            Shortcut("Alt + Space", "Bing up the Command Interface."),
            Shortcut("Ctrl + Esc", "Open the System Activity utility."),
            Shortcut("Super + Alt + Arrow keys", "Switch between windows."),
            Shortcut("Ctrl + F1 to F4", "Switch between virtual desktops."),
            Shortcut("Super + Tab", "Cycle between running applications."),
            Shortcut("Super + Shift + Tab", "Cycle between running applications in the opposite direction."),
            Shortcut("Ctrl + Alt + L", "Lock the current session."),
            Shortcut("Ctrl + Alt + Shift + Del", "Instantly log out without confirmation."),
            Shortcut("Ctrl + Alt + Shift + Page Up", "Instantly reboot without confirmation."),
        )
    }

    val xfceShortcuts by lazy {
        mutableListOf<Shortcut>(
            Shortcut("Super + P", "Open Xfce display settings."),
            Shortcut("Alt + F2", "Open a command prompt."),
            Shortcut("Ctrl + Alt + Arrow keys", "Move between virtual desktops."),
            Shortcut("Alt + Tab", "Cycle between running applications."),
            Shortcut("Alt + Shift + Tab", "Cycle between running applications in the opposite direction."),
            Shortcut("Alt + F4", "Close the window in focus."),
            Shortcut("Alt + F10", "Maximize the window in focus."),
            Shortcut("Ctrl + Alt + D", "Minimize all windows to show desktop."),
            Shortcut("Ctrl + Alt + Del", "Lock the current session."),
            Shortcut("Ctrl + Esc", "Display context menu."),
        )
    }

    val lxdeShortcuts by lazy {
        mutableListOf<Shortcut>(
            Shortcut("Ctrl + Alt + T", "Launch Terminal."),
            Shortcut("Shift + Alt + Arrow keys", "Move the window in focus between virtual desktops."),
            Shortcut("Ctrl + Alt + Arrow keys", "Move between virtual desktops."),
            Shortcut("Alt + Tab", "Cycle between running applications."),
            Shortcut("Alt + Shift + Tab", "Cycle between running applications in the opposite direction."),
            Shortcut("Alt + F4", "Close the window in focus."),
            Shortcut("Alt + Esc", "Hide the window in focus."),
            Shortcut("Super + D", "Minimize all windows to show desktop."),
            Shortcut("Super + E", "Launch the default file browser."),
            Shortcut("F11", "Toggle Fullscreen."),
        )
    }

    val cinnamonShortcuts by lazy {
        mutableListOf<Shortcut>(
            Shortcut("Ctrl + Alt + Down", "Show all currently running applications on the selected workspace."),
            Shortcut("Ctrl + Alt + Up", "Show running applications across all workspaces."),
            Shortcut("Alt + Tab", "Cycle between running applications."),
            Shortcut("Shift + Alt + Tab.", "Cycle between running applications in the opposite direction."),
            Shortcut("Alt + F2", "Open a command prompt."),
            Shortcut("Alt + F4", "Close the window in focus."),
            Shortcut("Super + L", "Open the Cinnamon Debugger."),
            Shortcut("Super + D", "Minimize all windows to show desktop."),
            Shortcut("Ctrl + Super + Arrow keys", "Span the window in focus to a border."),
            Shortcut("Shift + Ctrl + Alt + Left or Right Arrow", "Move the window in focus to the workspace on the left or right."),
        )
    }

    val bashShortcuts by lazy {
        mutableListOf<Shortcut>(
            Shortcut("Ctrl + A", "Go to the beginning of the selected line."),
            Shortcut("Ctrl + E", "Go to the end of the selected line."),
            Shortcut("Ctrl + K", "Cut the part of the selected line after the cursor and copy it to the clipboard."),
            Shortcut("Arrow Up", "Previously used command"),
            Shortcut("Alt + B", "Move the cursor back one word."),
            Shortcut("Alt + F", "Move the cursor forward one word."),
            Shortcut("Ctrl + L", "Clean the current screen."),
            Shortcut("Ctrl + J", "Enter the Newline control character."),
            Shortcut("Ctrl + R", "Search in your Bash history."),
            Shortcut("Ctrl + G", "Exit the history searching mode."),

            )
    }

    val ubuntuShortcuts by lazy {
        mutableListOf<Shortcut>(
            Shortcut("Super", "Open Activities"),
            Shortcut(" Alt + F2", "Open a command prompt."),
            Shortcut("Alt + Tab", "Cycle between running applications."),
            Shortcut("Super + Arrow keys", "Snap the window in focus to a border"),
            Shortcut("PrtSc", "Take a screenshot of the entire screen"),
            Shortcut("Alt + PrtSc", "Take a screenshot of the window in focus"),
            Shortcut("Shift + PrtSc", "Take a screenshot of a selected area on the screen"),
            Shortcut(" Ctrl + Alt + T", "Launch Terminal."),
            Shortcut("Super + L", "Lock the current session"),
            Shortcut("Super + D", "Minimize all windows to show desktop."),
        )
    }


    val firefoxShortcuts by lazy {
        mutableListOf<Shortcut>(
            Shortcut("Backspace", "Go back."),
            Shortcut("F5 or Ctrl + R", "Reload the current page"),
            Shortcut("Ctrl + P", "Print the current page"),
            Shortcut("Ctrl + S", "Save the current page"),
            Shortcut("Ctrl + F", "Find text on the current page"),
            Shortcut("Ctrl + K", "Bring the search bar into focus."),
            Shortcut("Ctrl + W", "Close the current tab"),
            Shortcut("Ctrl + N", "Open a new tab."),
            Shortcut("Ctrl + Shift + P", "Open a new private window."),
            Shortcut("Ctrl + Shift + Q", "Exit Firefox"),
        )
    }

    val chromeOSShortcuts by lazy {
        mutableListOf<Shortcut>(
            Shortcut(" Ctrl + Shift + L", "Lock the current session."),
            Shortcut("Ctrl + Shift + Q", "Log out from the current session."),
            Shortcut(" Alt + 1 to 8", "Launch an application from the taskbar"),
            Shortcut("Alt + [ or ]", "Dock the window in focus to the left or right side of the screen"),
            Shortcut("Ctrl + F5", "Take a screenshot of the entire screen"),
            Shortcut("Ctrl + Shift + F5", "Take a screenshot of a selected area on the screen"),
            Shortcut(" Shift + Alt + M", "Open the Files app."),
            Shortcut("Shift + Alt + N", "Display notifications"),
            Shortcut("Ctrl + Alt +", "Display all keyboard shortcuts"),
            Shortcut("Shift + Esc", "Open the Task Manager"),
        )
    }


    companion object {
        var instance: MyApplication? = null
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}