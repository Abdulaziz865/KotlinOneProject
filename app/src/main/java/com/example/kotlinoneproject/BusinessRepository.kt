package com.example.kotlinoneproject

class BusinessRepository {
    private val listOfCharacters = ArrayList<BusinessModel>()
    fun getListOfCharacters(): List<BusinessModel> {
        listOfCharacters.add(
            BusinessModel(
                "https://avatars.mds.yandex.net/i?id=358ef38c5d070e947d846ee41357859fd24cd965-5858200-images-thumbs&n=13",
                "Elon Musk",
                50,
                "#FFBB86FC"
            )
        )
        listOfCharacters.add(
            BusinessModel(
                "https://avatars.mds.yandex.net/i?id=f8d4eafb8881e59471de5b43b3eab937-4766550-images-thumbs&n=13",
                "Jeaff Bezos",
                57,
                "#FF6200EE"
            )
        )
        listOfCharacters.add(
            BusinessModel(
                "https://avatars.mds.yandex.net/i?id=77711a9248710a2e0ccb9c462b104bca-5192496-images-thumbs&n=13",
                "Mark Zukerberk",
                37,
                "#FF03DAC5"
            )
        )
        listOfCharacters.add(
            BusinessModel(
                "https://avatars.mds.yandex.net/i?id=38ace2f1a7460512985f76612fce68fd-5269624-images-thumbs&n=13",
                "Bill Gates",
                67,
                "#FFF8006B"
            )
        )
        listOfCharacters.add(
            BusinessModel(
                "https://avatars.mds.yandex.net/i?id=7a868e4a068d856e0fb3bc3aa5c6feae3c981cc1-6598906-images-thumbs&n=13",
                "Ali Baba",
                62,
                "#FF018786"
            )
        )
        listOfCharacters.add(
            BusinessModel(
                "https://avatars.mds.yandex.net/i?id=419bee2b179e034da7ed46f6a0ddd021a287520d-7111467-images-thumbs&n=13",
                "Steve Jobs",
                0,
                "#FFFF0000"
            )
        )
        listOfCharacters.add(
            BusinessModel(
                "https://avatars.mds.yandex.net/i?id=23ceb42f08f51bce7a5b3ab1a1340783a0e14b39-4499935-images-thumbs&n=13",
                "Sergei Brin",
                48,
                "#FF95FF00"
            )
        )
        listOfCharacters.add(
            BusinessModel(
                "https://avatars.mds.yandex.net/i?id=617fe63d434f3544e7a3f7beb41d6a2306516095-6946680-images-thumbs&n=13",
                "Larry Page",
                48,
                "#FFFFAA00"
            )
        )
        listOfCharacters.add(
            BusinessModel(
                "https://pbs.twimg.com/media/EDQ0Yi2XkAESOoV.jpg:large",
                "Deadjey Krim",
                52,
                "#FFFF00E5"
            )
        )
        listOfCharacters.add(
            BusinessModel(
                "https://images-media.currency.com/a7c6ec35/1dcb/5212/abbc/b0575fb4b79f/on_page/bernard-arnault.jpg",
                "Bernar Arno",
                77,
                "#FF063F6A"
            )
        )
        return listOfCharacters
    }
}