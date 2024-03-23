# Austin Susanto - 2206025060

## Reflection 1
In this tutorial, I have applied the coding standards such as:
* Using efficient variable naming
* Using functions to reduce repetitive codes
* Using proper and consistent indentation throughout the code

Eventhough there's not much problem in going through this tutorial, I still take a lot of time to get comfortable with the newly learned Java Springboot framework. 
There are probably still some minor problem with the usage of the framework. To improve this, I probably need some more time to adjust my self with the framework system. 
I also need to learn more about the MVC system used in the Java Springboot because it is a new system for me compared to the MVT.

## Reflection 2
1. After finished writing the unit test, I feel saver and more confident about my code. The unit test gave me a sense of reasurrance about my code correctness.
   In my opinion, the amount of unit tests to be made in a single class is relative to the amount of function inside the class. More functions needs more tests to check the correctness.
   The unit tests for our code also needs to meet certain expectations to be able to verify our program. Those expectations revolves around checking value correctness, function return value, etc. Its not only about getting a success in the test result.
   From the previous statements, I have a conclusion that 100% code coverage doesn't mean that the code have no bugs or errors.
2. Making a new Java class with the same setup procedures and instance variables genarally reduces the overall quality of the code. This is because it creates multiple codes with the same objectives.
   This approach could possibly result in some issues involving difficult development proccess due to similar or duplicate codes. It would be better to make include the new class into the old one with better segmentation.
   With that, we can reduce the duplication of code and make a cleaner and tidier development environment.

## Reflection 3
1. Most of the quality issues fixed in my code are related to code writing consistency and code usage. The fixes aren't complex and I only need to change and tidy up some messy code.
   On fixing these kinds of issues, it is important to stay patient and fix issues calmly so that the simple problem doesn't turn into a bigger problem.
2. The current workflows meets the definition of Continuous Integration and Continuous Deployment. It is because the workflows used automatically deploys the new features which are added to the repository.
   Although it meets the definition, it still has much room for improvement that can be implemented including failed deployment handling and others.

## Reflection 4
1. From the SOLID principles, I applied the SRP or Single Responsibility Principle. This principle helps the regulation of code inside the project. With this principle, code fixing and bug locating can be done easily
   and minimize the possibility of code crashes.
2. The SOLID principles helps to code and developing a program in every aspect. For example, if a project has some problem in it, it could be easily detected and located which helps the developer. Also, when a new feature in the project
   wants to be added, it can be written easily without making problems in other part of the code.
3. Without the SOLID principles, the codes inside the program will be hard to understand, maintain, and won't be flexible. For example, inside this project, it would be hard to locate which function in the controller is making a problem.
   This problem will also grow along with the size of the code. So the bigger the program, the bigger the problem.

## Reflection 5
1. The TDD flow is useful in someway, but because this is my first time implementing it, there's a lot of problem that I've encountered. Some problems includes too little understanding of the final product which slows down the test making proccess by a lot. The TDD flow demands the knowledge of the actual implemented final product understanding to run smoothly. This is why there is a proccess named "spiking" where we try to shape our understandings and picture the program so that we can make the tests easily. The problem in this assignment was that I didn't do any spiking proccess and skipping to the test creation. Thus, slowing down the proccess by a lot.
2. The tests done in this assignment are definitely fast and repeatable due to its small size and consistent inputs. I also think they are self-validating because I've put pretty strict assertion conditions. But they might not fully be isolated nor thorough. This is because I didn't fully use the mocking system the way that its meant to be used and I think I havent put enough test cases to check the program thoroughly. To make better tests, I think I need to use the mocks more formally and consider in advance what are the parts of the programs that needs to be tested.
