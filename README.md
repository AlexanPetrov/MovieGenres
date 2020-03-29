# MovieGenres

This is number 4 in the series of 5 assignments. The idea is to transfer data from .csv file/s to other data structirs to clean and analize data.

Similarely to privious programs, files were transfered from stack to arraylist followed by linkedlists  and treemaps. 

The main difference in this code is a few functionalities that allow analisis of date in more detail.

Functions such as countGenre are set to count genres of movies differentiating by name, finding, total, finding average. Placing a few conters this particular functiom can count movies by year or genre.

Second difference about this code is more extended use of maptree structure. I picked this particular
functionality over hashmap because it saved me time on sorting algorithms because it's already built
to sort values.

I used Regular Expressions again for one of the data conversion functions to pick out particular data
from strings. I discovered even though it works well enough in this context, it's not perfect. I am
planning to perfect it for future assignments. 

Special notice to yearSort() function. Unless most recent Java is installed, Strings for years will 
come out as chars.

I decided against visual representation of data by graph at this time firstly because java is not
great for it, and second I am not very familiar with wrappers to use java code with another 
language such as Python. Writting this again in Python is way easier in my case, but I'd prefer to
paractice Java. I would apreciate any tips on how to use wrappers in general for this particular 
purpose. 
