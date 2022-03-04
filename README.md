# TrappedKnight

The Trapped Knight is a mathematical problem centred arround chess, I wanted to personally tackle this problem to solve it myself. As it is both a mathematical problem to solve and a programming problem to code. I have found some new interesting things about java in the proces of doing it.

For an explanation of the problem, here is a complete article about it: https://scipython.com/blog/the-trapped-knight/

My java program uses 2 classes (main + Position), that being said I could use more or even less its just personal preference at the end. In the creation of this program I have used a 3rd party developed algorythm to go through a matrix and number each cell, from inside out, in a ascending numerical trend. Like this:
   
<pre>   .. .. .. .. .. </br>
.. 17 16 15 14 13 .. </br>
.. 18  5  4  3 12 .. </br>
.. 19  6  1  2 11 .. </br>
.. 20  7  8  9 10 .. </br>
.. 21 22 23 24 25 .. </br>
   .. .. .. .. .. </br></pre>
   
This algorythm is something of a one trick ponny since I'm fairly certain that I will never have to number a matrix in that way, ever again. That apart I found some problems, but they were all resolved as small bugs and memory problems for making the matrix too large. A sample execution of the program, will number every position that it lands and in the end it will print the entire matrix.

Example Run: 1, 10, 3, 6, 9, 4, 7, 2, 5, ..., 2880, 2467, 2084 (Always ending in that number as it cannot longer move).
