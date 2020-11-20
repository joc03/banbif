Feature: Consumo de API Red Digital

  @REDDIGITAL @API-RECAUDACIONES @PAGAR-SERVICIOS @Consultar
  Scenario Outline: Pagar Servicio

    Given  quiero ejecutar el API Red Digital  con la peticion "<caso_prueba>"
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
      |9          |
      |10         |
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
      |24         |
      |25         |
      |26         |
      |27         |
      |28         |
      |29         |
      |30         |
      |31         |
      |32         |
      |33         |
      |34         |
      |35         |
      |36         |
      |37         |
      |38         |
      |39         |
      |40         |
      |41         |
      |42         |
      |43         |
      |44         |
      |45         |
      |46         |
      |47         |
      |48         |



  @REDDIGITAL @API-RECAUDACIONES @CONVENIOS

  Scenario Outline: Consultar  Convenio
    Given  quiero ejecutar el API Red Digital  con la peticion "<caso_prueba>"
    When   gennero el token para ejecutarlo en el API "<caso_prueba>"
    And    consumo el api con la data de prueba "<caso_prueba>"
    Then   verifico el status code "<caso_prueba>"
    And    las respuestas esperadas en las rutas "<caso_prueba>" del response

    Examples:
      |caso_prueba|
      |49          |
      |50          |
      |51          |
      |52          |



  @REDDIGITAL @API-RECAUDACIONES @CONVENIOS

  Scenario Outline: Lista Detallada Convenio
    Given  quiero ejecutar el API Red Digital  con la peticion "<caso_prueba>"
    When   gennero el token para ejecutarlo en el API "<caso_prueba>"
    And    consumo el api con la data de prueba "<caso_prueba>"
    Then   verifico el status code "<caso_prueba>"
    And    las respuestas esperadas en las rutas "<caso_prueba>" del response

    Examples:
      |caso_prueba|
      |53         |
      |54         |
      |55         |
      |56         |
      |57         |
      |58         |
      |59         |
      |60         |
