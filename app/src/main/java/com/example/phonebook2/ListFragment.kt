package com.example.phonebook2

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController

class ListFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)

        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val contacts = listOf(
            ItemModel(R.drawable.img1, "Nguyễn Huy"),
            ItemModel(R.drawable.img2, "Nguyễn Huy"),
            ItemModel(R.drawable.img3, "Nguyễn Huy"),
            ItemModel(R.drawable.img1, "Nguyễn Huy"),
            ItemModel(R.drawable.img2, "Nguyễn Huy"),
            ItemModel(R.drawable.img3, "Nguyễn Huy"),
            ItemModel(R.drawable.img1, "Nguyễn Huy"),
            ItemModel(R.drawable.img2, "Nguyễn Huy"),
            ItemModel(R.drawable.img3, "Nguyễn Huy"),
            ItemModel(R.drawable.img1, "Nguyễn Huy"),
            ItemModel(R.drawable.img2, "Nguyễn Huy"),
            ItemModel(R.drawable.img3, "Nguyễn Huy"),
            ItemModel(R.drawable.img1, "Nguyễn Huy"),
            ItemModel(R.drawable.img2, "Nguyễn Huy"),
            ItemModel(R.drawable.img3, "Nguyễn Huy"),
            ItemModel(R.drawable.img1, "Nguyễn Huy"),
            ItemModel(R.drawable.img2, "Nguyễn Huy"),
            ItemModel(R.drawable.img3, "Nguyễn Huy"),
            ItemModel(R.drawable.img1, "Nguyễn Huy"),
            ItemModel(R.drawable.img2, "Nguyễn Huy"),
            ItemModel(R.drawable.img3, "Nguyễn Huy"),
            ItemModel(R.drawable.img1, "Nguyễn Huy"),
        )

        val listView: ListView = view.findViewById(R.id.list_view)
        val adapter = ItemAdapter(requireContext(), contacts)
        listView.adapter = adapter

        listView.setOnItemClickListener { parent, view, position, id ->
            val selectedContact = contacts[position]
            val nameAcc = selectedContact.nameAcc

            val detailFragment = InfDetailFragment.newInstance(nameAcc)
            requireActivity().supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container, detailFragment)
                .addToBackStack(null)
                .commit()

        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {

                    R.id.add_option -> {
                        Log.d("ListFragment", "Add option selected")
                        val addItemFragment = AddFragment()
                    requireActivity().supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment_container, addItemFragment)
                    .addToBackStack(null)
                    .commit()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
    }






