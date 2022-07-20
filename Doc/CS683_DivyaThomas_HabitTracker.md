# CS683 Project Assignment - Habit Tracker
### By Divya Thomas

--
## 1. Overview
In this day and age, people are busy. It's hard to stick to a routine and develop good habits while surrounded by distractions and long to-do lists. Since good habits are so important and beneficial to your overall wellbeing and everyday life, Habit Tracker is an organized consistent tool that can be used to keep people on track, especially those like me who LOVE to stay organized, keep lists, and track their progress. 

This is an application that allows users to plan out their daily habits and moods, with reminders and the ability to check thier consistency over time.

## 2. Related Work

My main inspiration for this application is the "Routines" iOS application by Care/Of. I use this application daily to track my morning and night routines. 

As someone who gets easily distracted by my phone in the morning or other priorities, this application has helped me tremendously in developing good, consistent habits that set me up for success. I have never felt more organized and accomplished than after I started using this application.

While the "Routines" application is strictly for morning and evening routines, rather than general habits. It allows users to set up and list customized steps to thier routines, and check them off as they go about their days. The application also provides reflection questions in which the user can assess their mental health and periodically encourages them when they have completed a consistent streak of completing particuar tasks over a course of time. At the end of the week, the user is able to find a detailed progress report connecting their reflections/moods with te consistency of thier completion of tasks in their routines.

I envision the Habit Tracker to e similar to this application in that it shows a list of custom items for the user to be able to check off as their days progress. I want this to also track trends and provide some sort of report and analysis of the user's progress. 


## 3. Requirement Analysis and Testing

|   |   |
|---|---|
|Title| Create/View Habit List (Essential) |
|Description| As a user I want to be able to create a list of habits I would like to include in my life so that I am able to customize to my preference and be able to view my list of expectations. |
|Mockups| ![image info](Pictures/list.jpg) |
|Acceptance Tests| Given a prompt is shown on the screen, The user is able to type a habit and add it to the list of existing habits already on the screen. |
|Test Results|Main Habit List Page (unfinished): ![image](Pictures/mainpage.png) Create Habit Page: ![image](Pictures/createhabitpage.png) ![image](Pictures/createhabittest.png) On submit: ![image](Pictures/newhabittestoutput.png) |
|Status|Iteration 1: Implemented an outline of the main page and completed implementation of the "Create Habit" page and saves a new Habit object on submit|
|TODO| Set up the Main Page to display all saved habits, and make them editable|

|   |   |
|---|---|
|Title| Check off/Mark Habits Complete (Essential) |
|Description| As a user I want to be able to mark each habit complete as I go about my day so that I am able to visualize my progress. |
|Mockups| ![image info](Pictures/markcomplete.PNG) |
|Acceptance Tests| Given the list of habits on the screen, The user is able to mark each one complete either through a radio button or checkbox. |
|Test Results|[TODO]|
|Status|[TODO]|

|   |   |
|---|---|
|Title| Refresh List (Essential) |
|Description| As a user I want to be able to refresh my habit list every day so that I am able to consistently go through this completion progress day by day and eventually develop a habit. |
|Mockups| ![image info](Pictures/refresh.PNG) |
|Acceptance Tests| Given that the screen shows a list of completed and not completed habits, the user is able to refresh the list to clear all checkmarks and start new with a list of non-completed tasks. |
|Test Results|[TODO]|
|Status|[TODO]|

|   |   |
|---|---|
|Title| Save Progress and Report (Desirable) |
|Description| As a user I want to track my completion rate of each habit and have some sort of report or feedback for reaching certain checkpoints (3 days in a row, 1 week, etc.). |
|Mockups| ![image info](Pictures/report.png) |
|Acceptance Tests| Given that a user selected to complete a habit, Data is then stored and the streak count for that habit is incremented. Vice versa when the user deselects the habit (different from refreshing) |
|Test Results|[TODO]|
|Status|[TODO]|

|   |   |
|---|---|
|Title| Prioritize Habits (Optional) |
|Description| As a user I want to be able to choose habits of higher importance so that I can focus on specific ones at a time if need be. |
|Mockups| ![image info](Pictures/priority.jpg) |
|Acceptance Tests| Given that the list of habits have varying priorities, The user can indicate high priority habits |
|Test Results|![image info](Pictures/prio.png) Output on submit: ![image info](Pictures/prioutput.png)|
|Status|Iteration 1: Set up a priority param upon creation of the habit|
|TODO (If time permits) | Set up sorting functionality on priority level on main habit page |

|   |   |
|---|---|
|Title| Set Reminders (Optional) |
|Description| As a user I want to be able to set a reminder on my phone for specific habits so that I am kept on track even when I forget to check the application itself. |
|Mockups| ![image info](Pictures/reminder.jpg) ![image info](Pictures/reminderalert.jpg)|
|Acceptance Tests| Given that the application can run in the background of others, The user sets a reminder on the application for a habit and the user is alerted at the specified time.|
|Test Results|![image info](Pictures/reminder.png) Output on submit: ![image info](Pictures/reminderoutput.png) |
|Status|Iteration 1: Set up a reminder param upon creation of the habit|
|TODO (If time permits) | Set up a push notification for reminders, allow user the option to turn off reminder |


## 4. Design and Implementation
Iteration 1:

This iteration consisted of configuring the general organization and setup of the application. All main pages have been created and will be enhanced as time progresses. 

The main "Habit List" page will display all habits to be checked off and refreshed by the user from time to time. The bottom right corner features a button to direct the user to the "Create Habit" page. It is desirable to have a sorting functionality added to this page to sort on priority levels in the future. 

UI Display: ![image info](Pictures/mainpage.png)

Source Code: 

![image info](Pictures/createhabitbutton.png) ![image info](Pictures/habitlistxml.png)Button functionality implemented in HabitList.kt and habit_list.xml

The secondary "Create Habit" page is vital to this application as it allows the user to create and customize thier own habits. It prompts the user to input a habit name, description, priority, and a daily reminder time for push notifications. The page features a cancel button to revert back to the main page without saving the new habit. It also has a submit button, which saves all inputted data into a new Habit object, defined by the Habit.kt data class. In the upcoming iterations, these objects will be stored in a database or JSON and pulled by the main Habit List page for display.

UI Display: ![image info](Pictures/createhabitpage.png)

Source Code: 

![image info](Pictures/createhabitxml.png) ![image info](Pictures/createhabitkt1.png) ![image info](Pictures/createhabitkt2.png) Create Habit page configuration (create_habit.xml and CreateHabit.kt)

Habit.kt data class structure: ![image info](Pictures/Habitkt.png)


## 5. Project Structure 
Iteration 1 Project Structure

![image info](Pictures/ProjectStructure1.png)


## 6. Timeline

|Iteration|Application Requirements|Android Components and Features to be used|
|---|---|---|
|1|Create/View Habit List (Essential)|Manifest File and basic UI display|
|2|Configure Habit List Display and Mark Complete Functionality|HabitList.kt, habit_list.xml|
|3|TBD|TBD|
|4|TBD|TBD|
|5|TBD|TBD|

## 7. Future Work 
[TODO] - Optional

## 8. Project Demo Links

Github Link: https://github.com/CS683/metcs683projects-divthomas22

## 9. References

Routines by Care/Of - https://apps.apple.com/us/app/routines-by-care-of/id1498695422
