Projeto Final: Sistemas Distribuídos

Sistema de Busca de Voos
O sistema deve possuir tabelas para cadastro da companhia aérea, avião, cidades, estados, pilotos e voos com o respectivo preço.

Para cada avião deve ser indicada a capacidade de passageiros. Para cada voo deve ser indicada a cidade de origem e destino, data/hora de partida e chegada, número do voo, preço do bilhete, avião, piloto e companhia áerea.

Não é preciso implementar classes DAO para cadastro de todas essas tabelas, mas apenas para aquelas exibidas na lista a seguir.

Devem ser disponibilizados os seguintes endpoints REST:

1.consultar voos por origem e destino

2.consultar voos por origem, destino e data de partida

3.consultar voos por origem, destino, data de partida e faixa de preço

4.cadastrar reserva do voo

5.alterar reserva do voo

6.excluir reserva do voo
