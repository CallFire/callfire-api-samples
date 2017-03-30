from callfire.client import CallfireClient

client = CallfireClient('api-login', 'api-password')
client.numbers.updateNumberLease(
    number='19206596476',
    body={
        'callFeatureStatus': 'DISABLED',
        'autoRenew': 'false'
    }
).result()
