from callfire.client import CallfireClient

client = CallfireClient('api-login', 'api-password')
response = client.keywords.findKeywords(
    keywords=['SUN', 'MOON']
).result()

print(response)
