from callfire.client import CallfireClient

client = CallfireClient('api-login', 'api-password')
response = client.me.getBillingPlanUsage().result()

print(response)
