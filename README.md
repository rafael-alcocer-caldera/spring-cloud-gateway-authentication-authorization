# SPRING CLOUD GATEWAY

## Synopsis

The project is a Spring Boot Application that calls the Authentication PostgresQL Service and creates the JSON Web Token. 

## Motivation

I wanted to extend the Authorization JWT Service [Spring Boot Authorization JWT](https://github.com/rafael-alcocer-caldera/spring-boot-authorization-jwt) that I have.

## Pre Requirements

- You need PostgresQL installed
- You need my [Spring Boot Authentication PostgresQL](https://github.com/rafael-alcocer-caldera/spring-boot-authentication-postgresql) and start it. It creates the database, after this you need to execute the queries that are in the queries.sql within the resource folder
- You need my [Spring Boot Authentication PostgresQL Authorization JWT](https://github.com/rafael-alcocer-caldera/spring-boot-authn-postgresql-authz-jwt)
- You need my [Spring Boot Elasticsearch Example](https://github.com/rafael-alcocer-caldera/spring-boot-elasticsearch-example)
- You need my [Spring Boot Elasticsearch Example](https://github.com/rafael-alcocer-caldera/spring-boot-kafka-producer-example)


USING POSTMAN:
--------------
<code><pre>


AUTENTICATION POSTGRESQL
------------------------
GET
http://localhost:8008/api/auth/login

Body
----
```json
{
    "username": "admin",
    "password": "admin"
}
```

Response
--------
```json
{
    "id": 1,
    "username": "admin",
    "email": "admin@admin.com",
    "authorities": [
        {
            "authority": "ROLE_ADMIN"
        }
    ],
    "accountNonExpired": true,
    "credentialsNonExpired": true,
    "accountNonLocked": true,
    "enabled": true
}
```


AUTHORIZATION JWT
-----------------
POST
http://localhost:8008/authorization

Body
----
```json
{
    "username": "admin",
    "password": "admin"
}
```

Response
--------
```json
{
    "username": "admin",
    "password": null,
    "jwt": "eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiI1NzUyZjk3Y2VlMTU0Mzk4YjU2NTJjMWE1YTc5NjcwZSIsImlzcyI6InJhcGlkc2hvcCIsInN1YiI6InRva2VuIiwiZXhwIjoxNjQ0MDM2MTkzLCJhdXRob3JpdGllcyI6WyJST0xFX1VTRVIiXX0.LwcLRf4hctSEncFVBvMBHzp-yCVPLZAPCVarSePaUZ22ZtnPamM_QKbs52cnirhftmiMdrlA2JZctRoQEE_Pow"
}
```


ELASTICSEARCH
-------------
GET
http://localhost:8008/elasticsearch/get

Headers
-------
Authorization
eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiI2ZGNkMDFjNmM1MDU0NzU3ODMwODUzOTQyZTA1ZTAyMCIsImlzcyI6InJhcGlkc2hvcCIsInN1YiI6InRva2VuIiwiZXhwIjoxNjQzMjU1MDc2LCJhdXRob3JpdGllcyI6WyJST0xFX1VTRVIiXX0.uJtXRWDQiIvJRjYq9Jvug9SPkz_thfRnxe7tu2YigSYfsUE0M0UWFz934W1VguNeZpiowyyhHF34L-0yZHoMfw

Body
----
```json
{"index": "productos", "id": "QK0Ckn0BDFf5vXyuB-bU"}
```

Response:
---------
```json
{
    "fields": {},
    "id": "QK0Ckn0BDFf5vXyuB-bU",
    "type": "_doc",
    "source": {
        "descripcion": "Pantalla LG UHD Smart TV de 50 pulgadas AI ThinQ 4K 50UP7500PSF",
        "dimensiones": "65cm x 25cm x 10cm",
        "colores_interiores": "blanco",
        "talla": 50,
        "peso": 5,
        "categoria": "TV y Video",
        "nombre": "Pantalla LG UHD Smart TV de 50 pulgadas AI ThinQ 4K 50UP7500PSF",
        "seccion": "Electronica",
        "marca": "LG",
        "existencias": 10,
        "precio": 8999,
        "detalle_venta": "si",
        "colores_exteriores": "negro",
        "subcategoria": "Pantalla",
        "genero": "",
        "fecha_alta": "2021-11-14",
        "descripcion_detallada": "Pantalla LG UHD Smart TV de 50 pulgadas AI ThinQ 4K 50UP7500PSF",
        "fecha_modifica": "2021-11-14",
        "activo": true
    },
    "index": "productos",
    "version": 1,
    "sourceAsString": "{\"nombre\":\"Pantalla LG UHD Smart TV de 50 pulgadas AI ThinQ 4K 50UP7500PSF\",\"seccion\":\"Electronica\",\"categoria\":\"TV y Video\",\"subcategoria\":\"Pantalla\",\"descripcion\":\"Pantalla LG UHD Smart TV de 50 pulgadas AI ThinQ 4K 50UP7500PSF\",\"descripcion_detallada\":\"Pantalla LG UHD Smart TV de 50 pulgadas AI ThinQ 4K 50UP7500PSF\",\"marca\":\"LG\",\"precio\":8999,\"genero\":\"\",\"existencias\":10,\"colores_exteriores\":\"negro\",\"colores_interiores\":\"blanco\",\"detalle_venta\":\"si\",\"talla\":50,\"peso\":5,\"dimensiones\":\"65cm x 25cm x 10cm\",\"activo\":true,\"fecha_alta\":\"2021-11-14\",\"fecha_modifica\":\"2021-11-14\"}",
    "primaryTerm": 1,
    "sourceAsMap": {
        "descripcion": "Pantalla LG UHD Smart TV de 50 pulgadas AI ThinQ 4K 50UP7500PSF",
        "dimensiones": "65cm x 25cm x 10cm",
        "colores_interiores": "blanco",
        "talla": 50,
        "peso": 5,
        "categoria": "TV y Video",
        "nombre": "Pantalla LG UHD Smart TV de 50 pulgadas AI ThinQ 4K 50UP7500PSF",
        "seccion": "Electronica",
        "marca": "LG",
        "existencias": 10,
        "precio": 8999,
        "detalle_venta": "si",
        "colores_exteriores": "negro",
        "subcategoria": "Pantalla",
        "genero": "",
        "fecha_alta": "2021-11-14",
        "descripcion_detallada": "Pantalla LG UHD Smart TV de 50 pulgadas AI ThinQ 4K 50UP7500PSF",
        "fecha_modifica": "2021-11-14",
        "activo": true
    },
    "exists": true,
    "seqNo": 0,
    "sourceAsBytes": "eyJub21icmUiOiJQYW50YWxsYSBMRyBVSEQgU21hcnQgVFYgZGUgNTAgcHVsZ2FkYXMgQUkgVGhpblEgNEsgNTBVUDc1MDBQU0YiLCJzZWNjaW9uIjoiRWxlY3Ryb25pY2EiLCJjYXRlZ29yaWEiOiJUViB5IFZpZGVvIiwic3ViY2F0ZWdvcmlhIjoiUGFudGFsbGEiLCJkZXNjcmlwY2lvbiI6IlBhbnRhbGxhIExHIFVIRCBTbWFydCBUViBkZSA1MCBwdWxnYWRhcyBBSSBUaGluUSA0SyA1MFVQNzUwMFBTRiIsImRlc2NyaXBjaW9uX2RldGFsbGFkYSI6IlBhbnRhbGxhIExHIFVIRCBTbWFydCBUViBkZSA1MCBwdWxnYWRhcyBBSSBUaGluUSA0SyA1MFVQNzUwMFBTRiIsIm1hcmNhIjoiTEciLCJwcmVjaW8iOjg5OTksImdlbmVybyI6IiIsImV4aXN0ZW5jaWFzIjoxMCwiY29sb3Jlc19leHRlcmlvcmVzIjoibmVncm8iLCJjb2xvcmVzX2ludGVyaW9yZXMiOiJibGFuY28iLCJkZXRhbGxlX3ZlbnRhIjoic2kiLCJ0YWxsYSI6NTAsInBlc28iOjUsImRpbWVuc2lvbmVzIjoiNjVjbSB4IDI1Y20geCAxMGNtIiwiYWN0aXZvIjp0cnVlLCJmZWNoYV9hbHRhIjoiMjAyMS0xMS0xNCIsImZlY2hhX21vZGlmaWNhIjoiMjAyMS0xMS0xNCJ9",
    "sourceEmpty": false,
    "sourceInternal": {
        "fragment": true
    },
    "sourceAsBytesRef": {
        "fragment": true
    },
    "fragment": false
}
```

</code></pre>

## License

All work is under Apache 2.0 license