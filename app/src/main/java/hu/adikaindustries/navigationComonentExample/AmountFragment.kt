package hu.adikaindustries.navigationComonentExample

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_amount.*
import kotlinx.android.synthetic.main.fragment_choose_recipiant.*
import kotlinx.android.synthetic.main.fragment_main.*
import java.math.BigDecimal


class AmountFragment : Fragment(), View.OnClickListener{
    lateinit var navController: NavController
    lateinit var recipient :String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recipient = arguments!!.getString("recipient").toString()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_amount, container, false)
    }


    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.send_btn->{
                if(!TextUtils.isEmpty(input_amount.text.toString())){
                    val amount = money(BigDecimal(input_amount.text.toString()))
                    val bundle = bundleOf(
                        "recipient" to recipient,
                        "amount" to amount)
                    navController.navigate(R.id.action_amountFragment_to_confirmationFragment,bundle)
                }else{
                    input_amount.setError("Enter an amount")
                }

            }
            R.id.cancel_btn2->activity!!.onBackPressed()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        send_btn.setOnClickListener(this)
       cancel_btn2.setOnClickListener(this)
        val message = "Sending money to $recipient"
        recipientText.text = message
    }



}