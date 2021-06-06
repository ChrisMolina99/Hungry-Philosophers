# Hungry Philosophers

## Description
This is a project representing the dilemma that face five philosophers that have to share chopsticks with their neighbors (not covid friendly) in a dining table. The philosophers are seated in a circular table where are placed five chopsticks, each one located between two philosophers. The problem is that the philosophers can eat their delicious rice when they have the two chopsticks in their hand.
![Dinner](/screenshots/demo.gif)


## Approach
Each philosopher has its own thread in which they wait until the chopsticks are free and then pick one at a time; once they finished eating, they release the chopsticks. But, it is necessary to consider the case where every philosopher takes the left chopstick and a dead lock occurs; to prevent this case, each philosopher holds the chopsticks for a fixed amount of time and the releases them. 

