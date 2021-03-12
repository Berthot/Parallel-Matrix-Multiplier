## **Exercício Paralelismo Distribuído: Multiplicador Paralelo de Matrizes**

Construa uma aplicação distribuída que multiplique duas matrizes _Am,k_ e _Bk,n_
produzindo uma matriz _Cm,n_ como resultado. Os valores dos elementos das
matrizes _A_ e _B_ devem ser números reais ( **double** ) lidos de dois arquivos, um
para cada matriz. Depois do processamento que calcula os elementos da matriz
_C,_ esses devem ser armazenados em um novo arquivo. (Os arquivos podem ser
do tipo txt ou do tipo csv.)

A aplicação deve explorar o potencial de paralelismo da plataforma distribuída a
fim de gerar os resultados em menor tempo. Para fins deste exercício, deve-se
assumir que a plataforma é uma rede composta por 5 computadores, sendo um
responsável por coordenar o processamento e os demais responsáveis por
realizar os cálculos. Na aplicação, há dois tipos de processos, a saber:

- **Coordenador** : responsável por orquestrar todo o trabalho da aplicação
- **Calculador** : responsável por calcular parte da matriz C

Em cada computador, há somente um processo da aplicação em execução.
Assim, um computador executa o **Coordenador** , enquanto os demais executam
o **Calculador** (4 instâncias).

O **Coordenador** realiza os seguintes passos:

1. carrega as matrizes _A_ e _B_ (a partir dos dados dos arquivos
    previamente gerados)
2. aloca espaço em memória para armazenar a matriz _C_
3. faz a divisão do trabalho de cálculo da matriz _C_ , determinando os
    intervalos da matriz _C_ que cada **Calculador** deverá resolver, de
    forma que cada Calculador determine aproximadamente a mesma
    quantidade de elementos da matriz _C_
4. envia mensagem para cada **Calculador** contendo a matriz _A_ , a matriz
    _B_ e os índices que determinam o intervalo a ser calculado (linha
    inicial, linha final, coluna inicial e coluna final)
5. aguarda as mensagens com a resposta (parte calculada da matriz _C_ )
    de cada **Calculador** , fazendo o preenchimento da matriz _C_
6. gera o arquivo correspondente à matriz _C_

A aplicação deve ser executada para matrizes _A_ e _B_ que possuam, no mínimo,
400 linhas e 400 colunas. Deve-se notar que essas matrizes não precisam ser
quadradas.

A comunicação entre Coordenador e Calcular deve ser implementada por meio
do protocolo TCP ou do protocolo UDP.

A aplicação deve ser implementada, se possível, em uma plataforma, de fato,
distribuída. Mas, também pode ser implementada num único computador, desde
que haja 5 processos em execução: uma instância de **Coordenador** e quatro
instâncias de **Calculador**.


