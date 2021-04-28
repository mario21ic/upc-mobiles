package pe.edu.upc.labcamera

import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.core.content.FileProvider
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*
import java.util.jar.Manifest

class MainActivity : AppCompatActivity() {
    private val REQUEST_GALLERY = 1001
    private val REQUEST_IMAGE_CAPTURE = 1002

//    private val carpetaPrincipal = "misImagenesApp/"
//    private val carpetaImagen = "imagenes/"
//    private val directorioImage = carpetaPrincipal + carpetaImagen

    private var rutaImagen: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    // Detectamos cuando se pulse el boton para abrir la galeria
    fun btnGaleriaClick(view: View) {
        Toast.makeText(this, "Aqui van las imagenes", Toast.LENGTH_LONG).show()
        val intentGaleria = Intent(Intent.ACTION_PICK)
        intentGaleria.type = "image/*"
        startActivityForResult(intentGaleria, REQUEST_GALLERY)
    }

    fun btnCameraClick(view: View) {
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

        try {

            var imagenArchivo: File
            imagenArchivo = crearImagen()
            if (imagenArchivo != null) {
                var fotoUri: Uri = FileProvider.getUriForFile(this, "pe.edu.upc.labcamera.fileprovider", imagenArchivo)
                Log.i("DEBUG", "fotoUri: $fotoUri" )
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, fotoUri)

                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
            }


        } catch (e: ActivityNotFoundException) {
            // display error state to the user
            Log.i("DEBUG", "Error: " + e.toString())
        }

//        dispatchTakePictureIntent()
    }

    // Captura el resultado
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val imageView = findViewById<ImageView>(R.id.imageView)

        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Log.i("DEBUG", "Vino de Camera")
//            val imageBitmap = data?.extras?.get("data") as Bitmap // usando data
            val imageBitmap = BitmapFactory.decodeFile(rutaImagen) // usando el archivo
            imageView.setImageBitmap(imageBitmap)
        }

        if (requestCode == REQUEST_GALLERY && resultCode == RESULT_OK) {
            Log.i("DEBUG", "Vino de gallery")
            imageView.setImageURI(data?.data)
        }
    }

    private fun crearImagen(): File {
        val nombreImagen = "foto_"
        val directorio: File? = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        val imagen: File? = File.createTempFile(nombreImagen, ".jpg", directorio)

        rutaImagen = imagen?.absolutePath.toString()
        return imagen!!
    }

//    lateinit var currentPhotoPath: String
//    @Throws(IOException::class)
//    private fun createImageFile(): File {
//        // Create an image file name
//        val timeStamp: String = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
//        val storageDir: File? = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
//        return File.createTempFile(
//            "JPEG_${timeStamp}_", /* prefix */
//            ".jpg", /* suffix */
//            storageDir /* directory */
//        ).apply {
//            // Save a file: path for use with ACTION_VIEW intents
//            currentPhotoPath = absolutePath
//            Log.i("DEBUG", "absolutePath: " + currentPhotoPath)
//        }
//    }
//
//    private fun dispatchTakePictureIntent() {
//        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
//            // Ensure that there's a camera activity to handle the intent
//            takePictureIntent.resolveActivity(packageManager)?.also {
//                // Create the File where the photo should go
//                val photoFile: File? = try {
//                    createImageFile()
//                } catch (ex: IOException) {
//                    // Error occurred while creating the File
//                    Log.i("DEBUG", "Error creando file " + ex.toString())
//                    null
//                }
//                // Continue only if the File was successfully created
//                photoFile?.also {
//                    val photoURI: Uri = FileProvider.getUriForFile(
//                        this,
//                        "com.example.android.fileprovider",
//                        it
//                    )
//                    takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI)
//                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
//                }
//            }
//        }
//    }

    fun btnCameraViewClick(view: View) {
        Toast.makeText(this, "CameraView", Toast.LENGTH_LONG).show()
        startActivity(Intent(this, CameraViewActivity::class.java))
    }

}
