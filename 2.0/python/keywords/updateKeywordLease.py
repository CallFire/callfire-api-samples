from callfire.client import CallfireClient

client = CallfireClient('api-login', 'api-password')
response = client.keywords.updateKeywordLease(
    keyword='SUN',
    body={
        'autoRenew': False
    }
).result()

print(response)
