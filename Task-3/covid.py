import requests
url =' https://www.worldometers.info/coronavirus'
r = requests.get(url)
import bs4
soup = bs4.BeautifulSoup(r.text, 'lxml')
cases = soup.find_all('div', class_ = 'maincounter-number')
data = []
for i in cases:
    span = i .find('span')
    data.append(span.string)
import pandas as pd
df = pd.DataFrame({'Covid_Data': data})
df.index = ['Total Cases', 'Total Deaths', 'Total Recovered']
df
df.to_csv('Covid_Data.csv')
