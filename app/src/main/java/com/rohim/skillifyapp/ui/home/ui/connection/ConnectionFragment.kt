package com.rohim.skillifyapp.ui.home.ui.connection

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rohim.skillifyapp.R
import com.rohim.skillifyapp.data.model.DummyData
import com.rohim.skillifyapp.databinding.FragmentConnectionBinding
import com.rohim.skillifyapp.ui.adapter.UserAdapter
import com.rohim.skillifyapp.ui.profile.DetailUserActivity

class ConnectionFragment : Fragment() {

    private var _binding: FragmentConnectionBinding? = null
    private val binding get() = _binding!!

    private lateinit var recyclerView: RecyclerView
    private lateinit var userArrayList: ArrayList<DummyData>
    private lateinit var userAdapter: UserAdapter

    lateinit var imageUser: Array<Int>
    lateinit var fullName: Array<String>
    lateinit var nameCompanyUser: Array<String>
    lateinit var descriptionUser: Array<String>
    lateinit var qualificationUser: Array<String>
    lateinit var phoneNumberUser: Array<String>
    lateinit var addressUser: Array<String>
    lateinit var emailUser: Array<String>
    lateinit var websiteUser: Array<String>
    lateinit var linkedinUser: Array<String>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        requireActivity().actionBar?.hide()

        _binding = FragmentConnectionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        userDummy()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.item_for_user)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = UserAdapter(userArrayList) {
            val intentTo = Intent(context,DetailUserActivity::class.java)
            intentTo.putExtra(PARCELABLE, it)
            startActivity(intentTo)
        }
    }

    private fun userDummy() {
        userArrayList = arrayListOf<DummyData>()

        imageUser = arrayOf(
            R.drawable.profile2,
            R.drawable.profile2,
            R.drawable.profile2
        )
        fullName = arrayOf(
            getString(R.string.firstname1),
            getString(R.string.firstname2),
            getString(R.string.firstname3)
        )
        nameCompanyUser = arrayOf(
            getString(R.string.name_company_user1),
            getString(R.string.name_company_user2),
            getString(R.string.name_company_user3)
        )
        descriptionUser = arrayOf(
            getString(R.string.desc1),
            getString(R.string.desc2),
            getString(R.string.desc3),
        )
        qualificationUser = arrayOf(
            getString(R.string.qualifications1),
            getString(R.string.qualifications2),
            getString(R.string.qualifications3),
        )
        phoneNumberUser = arrayOf(
            getString(R.string.phoneNumberUser1),
            getString(R.string.phoneNumberUser2),
            getString(R.string.phoneNumberUser3)
        )
        addressUser = arrayOf(
            getString(R.string.addressUser1),
            getString(R.string.addressUser2),
            getString(R.string.addressUser3),
        )
        emailUser = arrayOf(
            getString(R.string.emailUser1),
            getString(R.string.emailUser2),
            getString(R.string.emailUser3)
        )
        websiteUser = arrayOf(
            getString(R.string.websiteUser1),
            getString(R.string.websiteUser2),
            getString(R.string.websiteUser3),
        )
        linkedinUser = arrayOf(
            getString(R.string.linkedinUser1),
            getString(R.string.linkedinUser2),
            getString(R.string.linkedinUser3),
        )
        for (i in imageUser.indices) {
            val userList = DummyData(
                imageUser[i],
                fullName[i],
                nameCompanyUser[i],
                descriptionUser[i],
                qualificationUser[i],
                phoneNumberUser[i],
                addressUser[i],
                emailUser[i],
                websiteUser[i],
                linkedinUser[i]
            )
            userArrayList.add(userList)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        val PARCELABLE = "OBJECT"
    }
}