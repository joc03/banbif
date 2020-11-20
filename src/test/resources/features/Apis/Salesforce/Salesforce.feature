Feature: Consumo de API

  @Salesforce @Consultar

  Scenario Outline: Consultar Movimiento de Tarjeta

    Given  quiero ejecutar el API Salesforce  con la peticion "<caso_prueba>"
    When   gennero el token para ejecutarlo en el API "<caso_prueba>"
    And    consumo el api con la data de prueba "<caso_prueba>"
    Then   verifico el status code "<caso_prueba>"
    And    las respuestas esperadas en las rutas "<caso_prueba>" del response


    Examples:
      |caso_prueba|
      |1          |
      |2          |
      |3          |
      |4          |
      |5          |
      |6          |
      |7          |
      |8          |
      |11         |
      |12         |
      |13         |
      |14         |
      |15         |
      |16         |
      |17         |
      |18         |
      |19         |
      |20         |
      |21         |
      |22         |
      |23         |
      |20         |
      |21         |
      |22         |
      |23         |
      |24         |
      |25         |
      |26         |


  Scenario Outline: Consultar Movimiento de Producto

    Given  quiero ejecutar el API Salesforce  con la peticion "<caso_prueba>"
    When   gennero el token para ejecutarlo en el API "<caso_prueba>"
    And    consumo el api con la data de prueba "<caso_prueba>"
    Then   verifico el status code "<caso_prueba>"
    And    las respuestas esperadas en las rutas "<caso_prueba>" del response


    Examples:
      |caso_prueba  |
      |28           |
      |29           |
      |30           |
      |31           |
      |32           |
      |33           |
      |34           |
      |35           |
      |36           |
      |37           |
      |38           |
      |39           |
      |40           |
      |41           |
      |42           |
      |43           |
      |44           |
      |45           |
      |46           |
      |47           |
      |48           |
      |49           |
      |50           |
      |51           |
      |52           |
      |53           |
      |54           |



  Scenario Outline: Consultar Cronograma

    Given  quiero ejecutar el API Salesforce  con la peticion "<caso_prueba>"
    When   gennero el token para ejecutarlo en el API "<caso_prueba>"
    And    consumo el api con la data de prueba "<caso_prueba>"
    Then   verifico el status code "<caso_prueba>"
    And    las respuestas esperadas en las rutas "<caso_prueba>" del response


    Examples:
      |caso_prueba|
      |68          |
      |69          |
      |70          |
      |71          |
      |72          |
      |73          |
      |74          |
      |75          |
      |76          |
      |77          |
      |78          |
      |79          |
      |80          |
      |81          |
      |82          |




  Scenario Outline: Detalle Producto

    Given  quiero ejecutar el API Salesforce  con la peticion "<caso_prueba>"
    When   gennero el token para ejecutarlo en el API "<caso_prueba>"
    And    consumo el api con la data de prueba "<caso_prueba>"
    Then   verifico el status code "<caso_prueba>"
    And    las respuestas esperadas en las rutas "<caso_prueba>" del response


    Examples:
      |caso_prueba|
      |84          |
      |85          |
      |86          |
      |87          |
      |88          |
      |89          |
      |90          |
      |91          |
      |92          |
      |93          |
      |94          |
      |95          |
      |96          |
      |97          |
      |98          |

  Scenario Outline: Interaccion Cliente

    Given  quiero ejecutar el API Salesforce  con la peticion "<caso_prueba>"
    When   gennero el token para ejecutarlo en el API "<caso_prueba>"
    And    consumo el api con la data de prueba "<caso_prueba>"
    Then   verifico el status code "<caso_prueba>"
    And    las respuestas esperadas en las rutas "<caso_prueba>" del response


    Examples:
      |caso_prueba|
      |100        |
      |102        |
      |103        |
      |104        |
      |105        |
      |106        |
      |107        |
      |108        |
      |109        |
      |100        |
      |111        |
      |112        |
      |113        |
      |114        |
      |115        |
      |116        |