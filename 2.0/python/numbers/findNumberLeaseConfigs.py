from callfire.client import CallfireClient

client = CallfireClient('api-login', 'api-password')
response = client.numbers.findNumberLeaseConfigs(
    # filter by 4-7 digit prefix
    prefix='14245',
    # filter by city
    city='Los Angeles',
    # filter by state
    state='CA',
    # filter by zipcode
    zipcode='90940',
    # filter by local access and transport area (LATA)
    lata='123',
    # filter by rate center
    rateCenter='123',
    # filter by label
    labelName='my label',
    # search offset
    offset=0,
    # return 10 items per request
    limit=10,
    # return only specific fields
    fields='items(number,configType)'
).result()

# see sample JSON response for this API
# on 'curl' samples tab
print(response)
