# SecDroidBug
SecDroidBug is an Android debugger that simplifies debugging and testing of Android Apps for security properties. SecDroidBug interacts with an App running on an Android device and monitors its behavior and reports when there is any sensitive data leakage by the App to outside world through network interfaces. SecDroidBug allows setting of breakpoints where it will stop the running App. It monitors running App from first breakpoint till last breakpoint. SecDroidBug can watch variables supplied by the user. On each breakpoint it will give the list of variables touched by each of these watch variables. The debugger considers user supplied watch variables and other variables that store sensitive information e.g, location, contacts, etc as sensitive variables. Between the breakpoints, if any variable touches a sensitive variable, debugger includes it in the set of sensitive variables. SecDroidBug maintains and gives a list of sensitive variables line by line between the breakpoints. If any of these sensitive variables are sent to outside world the data leakage is reported.

SecDroidBug requires Java source code of the Android App. Therefore it can be used only with Apps whose source code is available. It is extremely useful for App developers to debug their Apps for security properties. 

## Prerequisite
1. Java 8 or higher
2. Android Adb tools (add platform-tools directory to path)
3. Netbeans 8.2 or higher (if not running using command-line)

## Usage

1. ### Runnning Android App to make it wait for SecDroidBug to connect 
   1. Find .apk file of the App, the APK must be debuggable.
   2. Run `./run.sh APK_FILE` to run the Android App. This will both install and run App 
      in debgug mode to wait for debugger to connect.

2. ### Runnning SecDroidBug

   SecDroidBug can be launched from both commandline and Netbeans IDE.

   1. ### Using Netbeans
      1. Download and open project with Netbeans 8.2
      2. Add downloaded tool.jar in the project into classpath of project
      3. Run project

   2. ### Using commandline
      1. Put `SecDroidBug.jar`, `sources_a` and `sinks_a` files from project in same folder
      2. Run SecDroidBug using `java -jar SecDroidBug.jar`

After launch, browse the source file and set breakpoints and click on 'Start Debugging' button.

We also developed a tool called 'ApiCallsWithDeb' to get method calls in Android App, which was useful for our testing . https://github.com/gsy18/ApiCallsWithDeb

