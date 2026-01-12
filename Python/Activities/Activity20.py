import pandas as pd

	
dataframe = pd.read_excel('sample.xlsx')
	
print("Number of rows and columns:", dataframe.shape)

	
print(dataframe['Email'])

	
print(dataframe.sort_values('FirstName'))