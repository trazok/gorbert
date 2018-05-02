Michael Walker

Chris Waldon

CS 4800

4/30/18

# House of the Rising Sun
### A Learning Experience


## Abstract (200-300)
#### Objectives

The goal was simple and straightforward. A coffee shop had opened and wanted a way for customers to order beverages remotely, without having to call in and place their orders, I sought to provide that functionality through an android application. The goal being that customers would be able to download the app from the Play store, create and customize their drink orders, and then submit them to the coffee shop. Customers would then be able to pick up and pay for their orders at the counter. Merchant transactions would be ideal, but are beyond the scope of the project, and would be implemented in the future. 

#### Methods

In order to achieve these goals, 	the project was broken down into it’s minimal component pieces. The next step was to develop a rudimentary, but functional version of the product. This was accomplished using Android Studio, SQLite, and an attempt at the Agile framework. Each weekly stint attempted to add some functionality, test, troubleshoot, and have working and “deployable” by Wednesday. While this wasn’t always feasible, it was the underlying methodology throughout the semester. 

#### Results

In short, the tangible result is a somewhat rudimentary but functional application that just needs to be pointed towards a server to begin transmitting orders. 

#### Keywords 

????
 

# Table of contents

- [Introduction and Overview](#introduction-and-project-overview)
- Development
	- [Design](#design)
	- Testing
- Server
- Results
- Conclusions
- References
 

# Introduction and Project Overview

After a local business expanded into a coffee bar, the business owners wanted a mobile application to facilitate ordering coffee remotely. The idea was that development of such an application would increase revenue by drawing in customers who were interested in coffee to-go and balance barista workloads by reducing spikes in in-person ordering. This would cut costs by allowing staff to be more productive with fewer employees at any given time.  
	An ideal solution would be available quickly, easy to use, integrate with the POS system in place, and be open for extension/modification in the future. On the user’s end, the application should be:
-	Intuitive
-	Provide access to the coffee menu
-	Allow customization of menu items
-	Enable customized items to be saved as favorites
-	Provide a means to place an order to the coffee shop


This section should be written assuming your reader has zero knowledge of your work and its background. You must bring the reader from "zero" to a level where they can understand the main ideas and results of your work. (This should be derived primarily from your Final Project Description document)
-	Introduces the problem, objectives, and the users (or customers) of project results, context of problem and issues that affect solution choices
-	Describes relevant background information. May include any alternative solutions (are there existing solutions or similar systems? give references) in terms of strengths and weaknesses.
-	Describe value or benefits of your solution and results
-	Problem scope--problems addressed and not addressed
-	Figures and system diagrams where possible to illustrate problems and solutions.
-	Summary of features


# Design development and test (800-1200)
-	Design - describe system components (e.g. software modules/components, libraries, etc.), interfaces, and operations. Use figures to illustrate your description, for example: photos, block diagrams, class diagrams, state diagrams, flow charts, tables, etc.
-	Development - describe how system was developed (for example, order of subsystem development and how risks were addressed early)
-	Test - describe your test approach (what was tested, how tested, what was not tested). You should organize this by feature (as you did for the System Features assignment).
Product development was broken into three primary categories – design, testing, and server interaction, with design and testing each being further subdivided into two additional categories. The process, in its entirety, used the following components at various stages:
-	Eclipse
-	Android Studio
-	Espresso
-	Apache Tomcat
-	Ngrok
-	Nexus 6 emulator (API 22)
-	Galaxy S7 (API 24)
-	SQLite Browser

## Design
### Program Design

Initial program design and logic testing actually took place outside of Android Studio to ensure that the class structure and logic, itself, was fully functional before introducing the nuances of Android specific requirements.
When first approaching the program design, there were several challenges encountered. First and foremost, what should the structure be under the hood? What is the best way to respresent a beverage and its components programmatically? The initial solution was to implement a decorator pattern in order to facilitate simple menu changes and extensions in the future. Allowing a Beverage to be constructed in this way meant that any additional features or options added to the Beverage were implemented by further wrapping the base Beverage. While this solution generated a large number of classes, each was small, single-use, and clean. However, when considering the need to allow a Beverage to be modified after its construction, it became clear that accessing and modifying a wrapping class that is an arbitrary and unknowable number of layers deep in the Beverage object was a considerable problem. As a result, Beverages were redesigned to contain all of the relevant information as fields. This drastically reduced the number of classes necessary, but meant that the previously small and clean code was all housed in a single class, making it decidedly larger and more cluttered. But, this also allowed Beverages to be constructed and subsequently modified with ease. 
	While Beverages are the focus of the project, and resultantly were the majority of the program design, there is also a ShoppingCart class to perform all the expected functions of a shopping cart. Design for the cart class was fairly straightforward and essentially followed the process: How many should there be – one; make it a singleton. Is it a large, resource-demanding class -- no; eager instantiation it is. What are the most basic and fundamental responsibilities of a cart – add things to a list and buy them; ArrayList it is. After the core add/buy functionality was established, the scope was expanded to consider features that are preferable in a shopping cart, though not necessarily required to be considered one. This led to removing and modifying items from the cart. As the implementation is an ArrayList, remove was fairly straightforward. Modifying was only slightly more work as it is necessary to first locate the correct Beverage in the list and then alter its data. 

### UI Design

UI design, unlike program design, provides far more immediate gratification. Working in Android Studio, any changes are immediately apparent which is quite satisfying, even if the elements aren’t yet wired up or functional. The goal for the UI design was primarily minimalism. Provide the absolute minimum elements for a user to be able to perform the necessary functions, and then build upon that framework as needed in order to balance simplicity with ease of use. The result is a streamlined interface that avoid being cluttered or over-complicated while remaining intuitive, effective, and user-friendly. Other similar apps and services were reviewed and, although many had more robust features, all tended towards a clean-looking minimalism. After toying with and testing several “sunrise-y” color schemes involving warmer colors and blues, the lighter schemes were scrapped. The lighter colors didn’t provide the desired level of contrast for readability and felt harsh and out of place. Ultimately, the color scheme was set at a dark brown with green accents. The reasoning being that the brown is coffee-esque and makes for good contrast and readability. There was also a lot of tampering with the background in an effort to make the application look less “basic”, but images made for a cluttered appearance and presents too many contrast inconsistencies, and no single color background looked complimentary enough to warrant the decrease in readability.

## Testing
	
Testing was unknown territory at the outset of the project. Tests were mystical things that had been run in the past to verify a program’s correctness, but there had never been an attempt to create them. And they were always used as an after-thought, a final assessment, not a key component of the development process to be used formatively to inform and motivate feature implementation. Testing throughout the process was done manually, and wasn’t automated until almost the end of development. Originally the prospect of writing tests was unfamiliar and daunting – how does one automatically test what exists, let alone testing what doesn’t exist yet. As development progressed, it just never seemed to be the right time to write tests; something was always already known to be broken and needed fixing, so time should be spend fixing intead of writing tests. So tests were put off and pushed back and back-burnered and procrastinated until they were all that was left. Not ideal.

### Unit Testing

Unit testing was the furnace in the McCallister’s basement. Terrifying, but for no real reason. It was, in large, what I had been doing all along; create a beverage, modify its fields, make sure every method returns what it should given the context and parameters. Why writing that as a repeatable assertion was less appealing than manually calculating it each time, I have no idea. I still have no real frame of reference on how many tests should exist, how thoroughly a given component should be tested, etc., but at least the prospect of writing them isn’t an ordeal anymore. 

### UI Testing

UI testing in Android Studio is normally accomplished with an additional framework called Espresso. Espresso is designed to simplify the UI testing process in two key ways; it automatically synchronizes the loading of UI components to eliminate timing errors and the need for waits, and it allows tests to be recorded. Not being familiar with the framework and its various classes and methods for testing UI elements, the automatic test recording/generation was an amazing feature. Or would have been if it worked as advertised. Automatically generated tests consistently fail, seemingly as a result of timing errors. That being the case, the framework has lost much of its appeal, and the UI tests for my project feel a bit sparse. They cover most of the general use cases I created, but I would prefer them to be much more comprehensive and robust as user interaction doesn’t necessarily have to be concise or linear in the way that most of the existing tests are. 

## Server

In order to test the ability to actually place an order, it was necessary to establish a dummy server and verify transmission of the order. This was done using a combination of Apache Tomcat, Java servlets, and Ngrok. Overall, it was a long and painful process that was the source of a lot of error, but eventually, it worked. Which was also my first experience with anything network related, and the line finally being logged to a text file on the server brought more joy than I care to admit.

# Result (800-1200)
	
The “final” product is a simple but workable application for a small coffee shop. The module does not currently interface with the existing POS system, as I was unable to acquire the API from the manufacturer; however, it does accurately transmit and log orders, allowing the potential for an employee to receive the orders and enter them manually into the system. In its current state, it allows a customer to select, customize, save, and order a coffee. It does not include payment services, but does inform the customer of the cost of their order prior to placing it, so as not to be surprised on arrival. 
	By far the biggest problems encountered in the process were setting up the remote server, and creating UI tests. In theory adjusting the application to a concrete server should be a simple address substitution at this point. It could point to an established server and transmit the order via an HTTP post or use the included test server with a modified address, but in either case the brunt of the work should be taken care of. 

- [x] Create a persistent menu database
- [x] Create a shopping cart
- [x] Create a persistent favorites database
- [x] Save/remove from favorites database
- [x] Customize a menu item and add to cart/favorites
- [x] Place an order to the server
- [ ] Provide full Spanish support
- [ ] Add tea functionality
- [ ] Receive push notification when order is ready
- [ ] Estimated time until ready when ordering



•		Actual results of project. Describe how well you met your objectives, feature by feature. A table of results will help to summarize this.
•	This section describes final system in terms of features completed and actual performance of the system under test.
•	Include discussion of problems encountered, accuracy of estimates
•	Use figures and diagrams whenever possible 
Conclusion and future work (400-800)
As a result, I would consider the endeavor a success.
•	Briefly summarize problem, approach and results
•	Describe your conclusions and "lessons learned" regarding the results
•	Describe utility of results
•	Suggest areas for further study and/or development

I feel like the ice skater who is ok with letting go of the wall, but still super wobbly. Design patterns have trade-offs, don’t always use them. Spend more time thinking about and planning out product before diving in and coding. Write tests before-hand. Test everything you want the program to do. Then make it do those things. Hire a design professional. Learn espresso to avoid test recording. Try kotlin. 

# References 


