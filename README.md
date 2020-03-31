# battle-api-msansen1  
 
battle-api-msansen1 created by GitHub Classroom

[![Generic badge](https://img.shields.io/badge/JAVA-11-GREEN.svg)](https://shields.io/)  
An api used as a microservice for the project [Pokemon GameUI](https://github.com/ALTEA-2019-2020/game-ui-msansen1)

[Demo Hosted on Heroku](https://battle-api-msn.herokuapp.com/)

#Configuration necessaire au lancement :  

|  Variable | Description  |
|:-:|:-:|
| API_POKEMONTYPE | Api de pokemontypes |
| API_TRAINERTYPE | Api de trainers |
| API_TRAINERTYPE_USERNAME | Api de trainers:Basic Auth connection Username |
| API_TRAINERTYPE_PASSWORD | Api de trainers:Basic Auth Password |

#API disponibles  
[Swagger url](https://battle-api-msn.herokuapp.com/swagger-ui.html)  
[JSON api-docs](https://battle-api-msn.herokuapp.com/v2/api-docs)

##BattlesController:  
	{POST /battles, produces [application/json]}: createBattle(String,String)  
	{GET /battles, produces [application/json]}: getAllBattles()  
	{GET /battles/{uuid}, produces [application/json]}: getBattle(UUID)  
	{POST /battles/{uuid}/{trainerName}/attack, produces [application/json]}: updateBattle(UUID,String)  

# Projets liés:  
- [Git GameUI](https://github.com/ALTEA-2019-2020/game-ui-msansen1)
- [Git Pokemon Api](https://github.com/ALTEA-2019-2020/pokemon-type-api-msansen1)
- [Git Trainer Api](https://github.com/ALTEA-2019-2020/trainer-api-msansen1)
- [Git Battle Api](https://github.com/ALTEA-2019-2020/battle-api-msansen1)

