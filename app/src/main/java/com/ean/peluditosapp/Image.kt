package com.ean.peluditosapp

class Image {
    private var Descripcion=""
    private var UrlImage=""

    constructor()

    constructor(Descripcion: String, UrlImage: String) {
        this.Descripcion = Descripcion
        this.UrlImage = UrlImage
    }


     fun getdescripcion():String {
        return Descripcion
    }
    fun getUrlImage():String {
        return UrlImage
    }

    fun setdescripcion(descripcion:String){
        Descripcion=descripcion;
    }
    fun setUrlImage(image:String){
        UrlImage=image;
    }


}