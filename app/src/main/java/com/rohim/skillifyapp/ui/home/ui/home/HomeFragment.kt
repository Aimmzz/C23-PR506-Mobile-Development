package com.rohim.skillifyapp.ui.home.ui.home

import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rohim.skillifyapp.R
import com.rohim.skillifyapp.data.model.JobEntity
import com.rohim.skillifyapp.databinding.FragmentHomeBinding
import com.rohim.skillifyapp.ui.adapter.JobAdapter
import com.rohim.skillifyapp.ui.job.DetailJobActivity

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private lateinit var adapter: JobAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var jobArrayList: ArrayList<JobEntity>

    lateinit var imageCompany: Array<Int>
    lateinit var titleJob: Array<String>
    lateinit var office: Array<String>
    lateinit var location: Array<String>
    lateinit var description: Array<String>
    lateinit var qualification: Array<String>
    lateinit var phoneNumber1: Array<String>
    lateinit var email: Array<String>
    lateinit var website: Array<String>
    lateinit var linkedin: Array<String>

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dataDummy()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.rv_job)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = JobAdapter(jobArrayList) {
            val intent = Intent(context,DetailJobActivity::class.java)
            intent.putExtra(INTENT_PARCELABLE, it)
            startActivity(intent)
        }
    }


    private fun dataDummy() {
        jobArrayList = arrayListOf<JobEntity>()

        imageCompany = arrayOf(
            R.drawable.logo_company2,
            R.drawable.logo_company3,
            R.drawable.logo_company4,
            R.drawable.logo_company5,
            R.drawable.logo_company6
        )
        titleJob = arrayOf(
            getString(R.string.jobtitle1),
            getString(R.string.jobtitle2),
            getString(R.string.jobtitle3),
            getString(R.string.jobtitle4),
            getString(R.string.jobtitle5)
        )
        office = arrayOf(
            getString(R.string.companyName1),
            getString(R.string.companyName2),
            getString(R.string.companyName3),
            getString(R.string.companyName4),
            getString(R.string.companyName5)
        )
        location = arrayOf(
            getString(R.string.address1),
            getString(R.string.address2),
            getString(R.string.address3),
            getString(R.string.address4),
            getString(R.string.address5)
        )
        description = arrayOf(
            getString(R.string.description1),
            getString(R.string.description2),
            getString(R.string.description3),
            getString(R.string.description4),
            getString(R.string.description5)
        )
        qualification = arrayOf(
            getString(R.string.qualifications1),
            getString(R.string.qualifications2),
            getString(R.string.qualifications3),
            getString(R.string.qualifications4),
            getString(R.string.qualifications5)
        )
        phoneNumber1 = arrayOf(
            getString(R.string.phoneNumber1),
            getString(R.string.phoneNumber2),
            getString(R.string.phoneNumber3),
            getString(R.string.phoneNumber4),
            getString(R.string.phoneNumber5)
        )
        email = arrayOf(
            getString(R.string.email1),
            getString(R.string.email2),
            getString(R.string.email3),
            getString(R.string.email4),
            getString(R.string.email5)
        )
        website = arrayOf(
            getString(R.string.website1),
            getString(R.string.website2),
            getString(R.string.website3),
            getString(R.string.website4),
            getString(R.string.website5)
        )
        linkedin = arrayOf(
            getString(R.string.linkedin1),
            getString(R.string.linkedin2),
            getString(R.string.linkedin3),
            getString(R.string.linkedin4),
            getString(R.string.linkedin5)
        )
        for (i in imageCompany.indices) {
            val jobList = JobEntity(
                imageCompany[i],
                titleJob[i],
                office[i],
                location[i],
                description[i],
                qualification[i],
                phoneNumber1[i],
                email[i],
                website[i],
                linkedin[i]
            )
            jobArrayList.add(jobList)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    companion object {
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }
}