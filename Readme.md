## Tarefa:

Uma tarefa possui um nome, descrição, numero e um boolean que marca se ela ja foi realizada ou não

----

### API

**GET /tarefas** retorna uma string que contem nome, descrição e boolean informando se ja foi feita ou não de todas as tarefas ja adicionadas

**POST /tarefas** adiciona uma tarefa à lista de tarefas; necessita de um json que contenha o nome e a descrição. Exemplo:

``"nome" : "Persistencia", "descricao" : "Implementar persistencia na lista de tarefas"``

**PUT /fez** marca uma tarefa como feita, precisa de um json que contenha o numero (começa de 0) da tarefa que você deseja marcar como feita

``"numero" : "1"``

**PUT /nao_fez** marca uma tarefa como não feita, funciona da mesma maneira que a /fez

**DELTE /delete** deleta uma tarefa com um certo numero, necessita de um json da mesma maneira que o /fez e /nao_fez

