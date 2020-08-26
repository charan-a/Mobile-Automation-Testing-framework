# Mobile-Testing-Automation

This is the complete project framework.

# Features

1. Utilises a General Store app.
2. Hardwired to run on an emulator called "Demo". 
3. No manual invocation of the emulator or appium server needed. Happens programmatically.
4. Cucumber & Maven are used to develop the framework.
5. Can run as a maven test through command prompt.
6. Object Repository as properties file is implemented.
7. Logging has been implemented.
8. Data Driven with Data Tables, Excel and Regular Expressions. 
9. Multiple feature files with multiple scenarios
10. Gestures like clicking, scrolling, entering text, checkboxes, switching context, slider, alert boxes, drag n drop have been implemented.
11. Reporting has been implemented through webpages with the help of pretty plugin.

# Prerequisites

1. Download and install **Java**  [Explain me how, JDK8](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html#license-lightbox)
2.  Configure Java environment variables  [Explain me how](https://confluence.atlassian.com/doc/setting-the-java_home-variable-in-windows-8895.html)
3. Download and install **Android Studio**  [Explain me how](https://developer.android.com/studio)
4. Configure Android environment variables  [Explain me how](http://www.automationtestinghub.com/setup-android-environment-variables/)
5. Configure Anroid emulator and name it **Demo**[Explain me how](https://developer.android.com/studio/run/managing-avds)
6. Download and install **Node.js**  [Explain me how](https://nodejs.org/en/download/)
7. Configure npm environment variables [Explain me how](https://stackoverflow.com/questions/27864040/fixing-npm-path-in-windows-8-and-10)
8. Download and install **Appium** [Explain me how](http://www.automationtestinghub.com/download-and-install-appium-1-6/)
9. You'll need an IDE. We suggest downloading and installing **Eclipse**. [Explain me how](https://www.eclipse.org/downloads/)
10. Configure **Maven** for Eclipse  [Explain me how](https://www.softwaretestinghelp.com/eclipse/configuring-maven-with-eclipse/)
11. Configure **Cucumber** for Eclipse [Explain me how](https://www.javatpoint.com/install-cucumber-eclipse-plugin)

# About the tools/softwares/concepts used
1. **Java**: [Read about me](https://en.wikipedia.org/wiki/Java_(programming_language))    
2. **Appium**: [Read about me](http://appium.io/docs/en/about-appium/intro/?lang=en)    
3. **BDD**: [Read about me](https://en.wikipedia.org/wiki/Behavior-driven_development)
4. **Cucumber**: [Read about me](https://en.wikipedia.org/wiki/Cucumber_(software))  
5. **Maven**: [Read about me](https://en.wikipedia.org/wiki/Apache_Maven)  
6. **Android Studio**: [Read about me](https://en.wikipedia.org/wiki/Android_Studio)
 

# Running the project
1. Download the repository [UseMe](https://github.com/WiaN09/Citi/archive/master.zip) and unzip it, ideally in eclipse-workspace . 
2. Make sure the **GeneralStore.apk** present in Automation folder is installed in the emulator.
3. To directly run the tests (from command propmpt), open Automation folder and run either of three **.bat** files.  
4. To manually run the tests from command prompt, move inside the project location through **cd** command. Run    
    i: **mvn test**: Runs all feature files   
    ii: **mvn test -Dcucumber.options="src/test/java/features/XYZ.feature"**: Substitute 'XYZ' with the name of the feature file to run that specific feature file    
5. To manually run as a Maven project, first import it.  [Explain me how](http://people.cs.uchicago.edu/~kaharris/10200/tutorials/eclipse/import.html)
6. To run, **Automation->src/test/java->runner**. Right click **LogRunTest.java** and select **Run As**, left click **JUnit test**.

# Project Structure
## Packages
### base
**Log.java**: Initialises log4j instance and houses different kinds of logging methods.  
**Reader.java**: Responsible for reading the contents of the Object Repository.  
**Utilities.java**: Houses methods for different gestures, called upon by classes in stepDefs package.  
### data
**repo.properties**: Holds the locators and their XPaths as key-value pairs. Needs reading from.  
### excelUtls
**DataHelper.java**: Reads the contents of the Excel file and arranges as Hashmaps.  
**ExlUtils.java**: Has methods for reading Excel data directly called upon by DataHelper class.   
**data.xlsx**: Stores the data required for the app, like Name, Country, Gender etc.
### features
**Data.feature**: Houses detailed scenario for navigation through the app. Data held in *Examples* datatable.  
**Excel.feature**: Performs the same actions as Data.feature albeit using data from an Excel file.  
**Gesture.feature**: More focused towards displaying web gestures, eg alerts, slider, drag-drop. Cuts down on steps for app navigation. 
### runner
**LogRunTest.java**: Responsible for running tests as Cucumber. Holds plugin for generating *reports*.  
### stepDef
**ExcelLogIn.java**: Handles step definitions for Excel.feature which converts data to Hashmaps. Mainly intended for LogIn page.
**Hook.java**: Starts the appium server and the emulator. Initialises device capabilities. Closes the appium server and driver. 
**LogIn.java**: Handles step definitions for Data.feature which converts data to 2D Lists. Mainly intended for LogIn page.    
**Products.java**: Handles step definitions for Products page.
**Web.java**: Handles step definitions for Webpages in webview.  
#### log4j.properties
Defines the configuration for the logging used.
## External files
**General-Store.apk**: The app tested  
**RunFeatureData.bat**: Runs and tests the Data.feature in command prompt.  
**RunFeatureExcel.bat**: Runs and tests the Excel.feature in command prompt.  
**RunFeatureGesture.bat**: Runs and tests the Gesture.feature in command prompt.    
**log4j.log**: Everything gets logged in this file.  
**pom.xml**: Heart of the maven project. Houses all dependancies and external plugins.  
