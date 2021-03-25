package pe.edu.upc.lab3kotlinejercicio1.ui.clientes

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import pe.edu.upc.lab3kotlinejercicio1.R

class ClientesFragment : Fragment() {

    companion object {
        fun newInstance() = ClientesFragment()
    }

    private lateinit var viewModel: ClientesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.clientes_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ClientesViewModel::class.java)
        // TODO: Use the ViewModel
    }

}