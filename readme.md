Message System - messages from application-to-application
queueing data
web interface
user access control

docker run -d --restart always --name rabbitmq --hostname docker-rabbitmq -p 5672:5672 -p 15672:15672 -v C:/rabbitmq/data:/var/lib/rabbitmq/mnesia rabbitmq:management

publisher send message - json string - send to queue
subscriber consume message - consume from queue

Queue: a buffer to store messages
Exchange: routing message to queue
Routing key (address for the message): a key that the exchange looks at to decide how to route the message to queue/ which queue(s) to route to
Binding: link between exchange to queue

