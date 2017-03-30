from callfire.client import CallfireClient

client = CallfireClient('api-login', 'api-password')
response = client.keywords.isKeywordAvailable(keyword='SUN').result()

print(response)
