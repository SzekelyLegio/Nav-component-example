package hu.adikaindustries.navigationComonentExample

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_choose_recipiant.*

class ChooseRecipiantFragment : Fragment() , View.OnClickListener{
    lateinit var navController: NavController
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_choose_recipiant, container, false)
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.nav_button->{
                if(!TextUtils.isEmpty(input_recipient.text.toString())){
                    val bundle= bundleOf("recipient" to input_recipient.text.toString())
                    navController.navigate(R.id.action_chooseRecipiantFragment_to_amountFragment2,bundle)
                }else{
                    input_recipient.setError("Enter a name!")
                }

            }
            R.id.cancel_btn-> activity!!.onBackPressed()

        }
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        nav_button.setOnClickListener(this)
        cancel_btn.setOnClickListener(this)
    }


}