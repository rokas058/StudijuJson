# StudijuJson

Kad veiktu programa reikia atsisiusti koda.
Tada pačiame kode reikia nueiti i resources/aplication.properties.
Ten reikia prisijungti duomenu baze (MySQL) ir uzplidyti savo duomenimis pirmas tris eilutes:
spring.datasource.url=
spring.datasource.username=spring.datasource.password=

Prisijungus savo duomenu baze per Postman naudoti PUT metoda per http://localhost:8080/api/studijos ir issiusti json formatu duomenis pvz:

{
    "darboPradzia": "2023-05-12",
    "darboPabaiga": "2023-05-15",
    "darboApimtis": 4,
    "darboUzimtumas": [
        {
            "dienosData": "2023-05-12",
            "uzimtosValandos": 8
        },
        {
            "dienosData": "2023-05-13",
            "uzimtosValandos": 4
        }
    ]
}
