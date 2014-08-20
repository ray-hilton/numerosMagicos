Certified Scrum Developer - Módulo de Testes
=========

Durante esse módulo, criaremos um pequeno simulador de cotidiano de um desenvolvedor. Em cada etapa, você terá algumas opções que podem deixar seu dia mais leve ou mais estressante. O seu nível de stress pode variar de 0 a 10 e esse coeficiente influenciará a probabilidade de você se envolver em determinados eventos durante o dia.

- Acordar
- Café da Manhã
- Ida ao Trabalho
- Almoço
- Fim do Expediente
- Volta do Trabalho
- Filme pra relaxar

O módulo de testes do CSD se dividirá em 4 etapas:


## Testes

#### Gerenciamento de dependências

Para escrever e rodar testes é necessário adicionar algum *framework* de testes ao seu classpath. Mas vamos fazer isso de uma maneira mais profissional: usando o [Gradle][1].

O **Gradle** é uma ferramenta de automação de *builds* que faz o trabalho dos conhecidos [Maven][2] e [Ant][3] de uma maneira mais sucinta e auto-explicativa. Sua sintaxe é menos verbosa e de fácil compreensão, e por esse motivo o utilizaremos bastante no decorrer do curso.

O arquivo `build.gradle` é onde declaramos as dependências e tarefas de nossa aplicação. Para esse repositório, utilizamos também alguns plugins para facilitar a execução da aplicação.

Vamos utilizar o [JUnit][4] para executar os testes. Para incluí-lo no projeto basta descomentar a seguinte linha no arquivo `build.gradle`:

```groovy
testCompile group: 'junit', name: 'junit', version: '4.11'
```

Essa linha informa ao gradle que nossos testes dependem da biblioteca Junit. Com isso, qualquer tarefa que execute testes verificará se o JUnit está presente e o baixará automaticamente do repositório Maven caso seja necessário.

Embora não seja um assunto ligado diretamente ao TDD, o gerenciamento de dependências é extremamente importante para que possamos garantir a uniformidade entre os ambientes de desenvolvimento. Se você desenvolver sempre dessa forma, fica fácil garantir que o servidor de CI e as máquinas de todo o time estão trabalhando com as mesmas dependências.

#### Escrevendo seu primeiro teste

Tente digitar `gradle tasks` na linha de comando. O Gradle listará todas as tarefas que podem ser executadas em nosso projeto atual. Vamos focar agora em duas tarefas principais:

* `gradle run`

Esse comando executa nossa aplicação diretamente na linha de comando. E como o primeiro acontecimento já está implementado, podemos ver o que acontece se escolhemos acordar cedo ou tarde.

O plugin *application* foi incluído no `build.gradle` para que o Gradle soubesse que nosso projeto se trata de uma aplicação. Além disso, também informamos nesse arquivo onde estão nossas classes Java e qual delas é o ponto de entrada de nossa aplicação.

* `gradle test`

Com esse comando rodamos os testes existentes para nosso projeto. Assim como as classes da aplicação, o diretório onde nossos testes ficam é configurado no arquivo `build.gradle`. No momento, temos apenas um teste para a classe `Despertar.java`. Dê uma olhada no arquivo `DespertarTests.java` e tente implementar seu primeiro teste para o método `getOpcoes` da classe `Despertar`.

------------------

## TDD

#### Implementando a rotina do café da manhã e seu teste logo depois

Para o café da manhã, vamos fazer algo um pouco diferente. Você terá duas opções: um café **light** com frutas e um café **americano** com bacon, ovos, bacon, calabresa, bacon e bacon. Mas dessa vez a pontuação ganha irá variar de acordo com o seu humor atual.

* Para o café **light**:
 * Se sua pontuação de humor atual estiver abaixo de 10, comer pouco só vai te deixar mais mal-humorado. Então você perde mais alguns pontos de humor (a seu critério).
 * Caso seu humor esteja acima de 10, você vai ficar ainda mais feliz por conseguir se manter na dieta! Ganhe alguns pontos de humor a seu critério.
 
*  Para o café **americano**:
 * Se seu humor está abaixo de 10 um café reforçado com bacon pode ser exatamente o que você precisa para reverter a situação. Ganhe alguns pontos de humor a seu critério.
 * Caso seu humor esteja acima de 10, comer demais logo de manhã pode trazer aquele peso na consciência... Penalize seu humor a seu critério. 


Após implementar seu acontecimento de café da manhã, adicione-o à lista de acontecimentos na classe `RotinaDeProgramador` e rode a aplicação com o comando `gradle run`.

**Hora de escrever o teste!** O café da manhã tem mais variações e dependências que o acontecimento anterior, então seus testes serão um pouco mais complicados.

#### Alterando um teste para usar mocks e stubs

Esse teste acabou sendo um pouco mais complicado que o primeiro, não é mesmo? Isso aconteceu porque existe uma dependência do humor atual para que o modificador seja calculado. É aí que entram os **mocks**, **stubs** e **spy**:

* **Mocks** são dublês de um objeto. Quando você não quer/não pode criar um determinado objeto mas precisa passá-lo como parâmetro para algum método, mocks são exatamente o que você precisa.

* **Stubs** são dublês de métodos. Quando você não pode/não quer que um método seja chamado durante um teste, você pode criar um stub que será invocado no lugar do método original.


* Um **Spy** é capaz de informar quantas vezes um determinado método foi chamado e quais parâmetros ele recebeu. Sua função é muito parecida com a do **Stub**, e ele é muito útil quando queremos testar uma unidade que tem interfaces com outros sistemas, como _WebServices_ ou mesmo algum _hardware_.

Em Java, a biblioteca mais utilizada para se criar Mocks e Stubs é o [Mockito][5]. Ele já está incluso nas dependências do `build.gradle` e um teste de exemplo bem simples foi criado no arquivo `CafeDaManhaTests.java`.

Agora é com você: termine seu teste do café da manhã utilizando suas novas ferramentas.

**Tempo do exercício:** 25 minutos.

#### Escrevendo o teste unitário antes

Hora de experimentar o famigerado TDD enquanto enfrentamos um trânsito pesado. Ou não. Como o trânsito é caótico e imprevisível, nossa classe de trânsito terá uma premissa muito simples:

* Independentemente de seu humor atual, você tem 42% de chances de ficar preso em um engarrafamento enquanto vai para o trabalho. Se ficar preso, perde alguns pontos de humor. Se não ficar, ganha um pontinho.

Sinta-se à vontade para criar seus próprios métodos na classe `IdaAoTrabalho`, mas lembre-se de escrever os testes antes de qualquer coisa.

**Tempo do exercício:** 40 minutos.

------------------

## Cobertura e RTD

Você já deve ter notado que um relatório HTML é gerado a cada vez que você roda os testes. Esse relatório informa o resultado de cada método de testes e o percentual de sucesso de todos eles. Mas existe um outro relatório muito interessante que podemos obter através dos testes: o relatório de **cobertura de código**.

#### Adicionando e entendendo mais sobre cobertura de código
O **Gradle** possui um excelente plugin para avaliação de cobertura de código chamado [Jacoco][6]. Você pode conferir o arquivo `build.gradle` e procurar por `jacoco` para ver o quão simples é configurá-lo.

Para emitir nosso primeiro relatório de cobertura, precisamos rodar 3 comandos:

* `gradle clean`: Esse comando limpará os resultados dos testes rodados anteriormente. Ele é necessário para que os testes rodem novamente sob a influência do Jacoco.
* `gradle test`: Vamos rodar os testes normalmente. A ação do Jacoco é transparente e apenas implica em um pequeno aumento no tempo de execução dos testes.
* `gradle jacocoTestReport`: Essa nova tarefa foi adicionada com a inclusão do plugin Jacoco. Ela vai gerar o relatório HTML na pasta `build/jacocoHtml/`

Lembre-se que você pode sempre conferir as tarefas disponibilizadas pelo Gradle através do comando `gradle tasks`.

O relatório de cobertura é uma excelente maneira de descobrir situações que passaram despercebidas em nossos testes. Por exemplo: *o que acontece se alguém informar um número de opção inexistente em um acontecimento?*.

#### Criando seu próprio ambiente RTD

***Real Time Development*** é um conceito relativamente novo que prega o feedback instantâneo de testes e análise estática de código. Exatamente da mesma forma como a maioria das IDE's compila automaticamente seu código sem que você precise clicar no botão *build*.

Esse conceito é ainda mais interessante quando trabalhamos com linguagens dinâmicas, onde o compilador é menos restritivo. Mas o feedback dos testes é importante em qualquer linguagem, afinal:

> O compilador consegue garantir que o código que você escreveu está aderente às regras sintáticas da linguagem de programação utilizada. Os testes garantem que seu código está aderente às regras de negócio de seu produto.

O plugin `watch` foi adicionado no arquivo `build.gradle` e configurado para monitorar os diretórios de código e testes. Além disso, o plugin `announce` foi adicionado para prover um feedback mais amigável sempre que algum arquivo for alterado.

Tente gastar alguns minutos entendendo o que as novas linhas do arquivo `build.gradle` estão fazendo por você. Quando se sentir satisfeito, abra um terminal e digite o comando `gradle watch`.

Agora... **Experimente o RTD**. Teremos duas Sprints de 25 minutos para implementar os 4 acontecimentos restantes. As regras do jogo serão definidas por cada equipe.

**Tempo do exercício:** 1 hora.

------------------    

## Red-Green-**Refactor**

Testes são importantíssimos para facilitar a refatoração de código, pois deixam o desenvolvedor mais livra para alterar o código sem o eterno medo de estragar o que já estava funcionando. É assim que funciona o ciclo Red-Green-**Refactor**.

* **RED**: Você escreve um teste que não passa, pois a implementação ainda não foi realizada.
* **GREEN**: Você faz o que sabe fazer de melhor: implementa a solução e faz o teste escrito anteriormente passar.
* **REFACTOR**: Como temos o teste para garantir o funcionamento de nossa implementação, podemos aprimorar o código escrito e tornar futuras manutenções ainda mais fáceis.

É hora de praticar

#### Refatorando a impressão por extenso com testes com testes

Uma nova classe `Extenso.java` foi adicionada ao projeto. Trata-se de um código de baixa qualidade que recebe um número como parâmetro e o escreve por extenso. Se você rodar nossa aplicação, verá que o resultado final agora é escrito por extenso.

É hora de:

* Escrever testes para validar se essa classe realmente funciona para todos os casos. Que tal números negativos?

* Refatorar a classe tranquilamente enquanto seus testes garantem o sono de hoje a noite.

------------------

[1]: http://www.gradle.org/
[2]: http://maven.apache.org/
[3]: http://ant.apache.org/
[4]: http://junit.org/
[5]: http://code.google.com/p/mockito/
[6]: http://www.gradle.org/docs/current/userguide/jacoco_plugin.html