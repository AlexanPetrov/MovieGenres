from matplotlib import pyplot as plt

totalNumberOfGenres = [1, 2, 3, 4, 5, 6, 7, 8, 9] 

numberMoviesPerGenere = [66, 128, 794, 10, 49, 18, 26, 272, 76573]

plt.scatter(totalNumberOfGenres, numberMoviesPerGenere)

plt.show();
