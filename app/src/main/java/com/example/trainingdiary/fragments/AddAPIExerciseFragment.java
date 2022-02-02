package com.example.trainingdiary.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;

import com.example.trainingdiary.objects.classes.Exercise;
import com.example.trainingdiary.ExercisesDataService;
import com.example.trainingdiary.R;
import com.example.trainingdiary.databinding.FragmentAddApiExerciseBinding;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class AddAPIExerciseFragment extends Fragment{

    FragmentAddApiExerciseBinding binding;
    ExercisesDataService exercisesDataService;
    ArrayList<String> exercisesList = new ArrayList<>();
    TextView txtName, txtMusclePart, txtDescription;
    Button confirm;
    ListView listView;
    ArrayAdapter<String> arrayAdapter;
    JSONArray apiData;
    SearchView searchView;
    private static final String EXERCISE_KEY = "exercise_key";
    private Exercise exercise = new Exercise();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        getActivity().setTitle(getString(R.string.select_exercise_title
        ));
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentAddApiExerciseBinding.inflate(inflater, container, false);
        listView = binding.listView;

        exercisesDataService = new ExercisesDataService(AddAPIExerciseFragment.this.getContext());

        exercisesDataService.getExercises(new ExercisesDataService.VolleyResponseListener() {
            @Override
            public void onError(String message) {
                Toast.makeText(AddAPIExerciseFragment.this.getContext(), "error", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(JSONArray[] response) {
                String exerciseName = "";
                apiData = response[0];
                for (int i = 0; i < response[0].length() - 1 ; i++) {
                    try {
                        exerciseName = response[0].getJSONObject(i).getString("title");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    exercisesList.add(exerciseName);
                }
                arrayAdapter = new ArrayAdapter<>(AddAPIExerciseFragment.this.getContext(), android.R.layout.simple_list_item_1, exercisesList);
                listView.setAdapter(arrayAdapter);

                binding.getRoot();
            }
        });
        return  binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        txtName = binding.txtApiTitle;
        txtMusclePart = binding.txtApiMusclePart;
        txtDescription = binding.txtApiDescription;

        confirm = binding.btnConfirmApiExercise;
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle result = new Bundle();
                result.putString("bundleKey", "addAPIExerciseToWorkoutButtonClicked");
                result.putSerializable(EXERCISE_KEY, exercise);
                getParentFragmentManager().setFragmentResult("requestKey", result);
            }});

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.search_menu, menu);
    }

    @Override
    public void onOptionsMenuClosed(@NonNull Menu menu) {
        super.onOptionsMenuClosed(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_search:
                searchView = (SearchView) item.getActionView();

                searchView.setQueryHint("wyszukaj cwiczenie");
              item.setOnActionExpandListener(new MenuItem.OnActionExpandListener() {
                  @Override
                  public boolean onMenuItemActionExpand(MenuItem item) {
                      listView.setVisibility(View.VISIBLE);
                      return true;
                  }

                  @Override
                  public boolean onMenuItemActionCollapse(MenuItem item) {
                      listView.setVisibility(View.GONE);
                      return true;
                  }
              });

                searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                    @Override
                    public boolean onQueryTextSubmit(String query) {
                        return false;
                    }

                    @Override
                    public boolean onQueryTextChange(String newText) {
                        if(arrayAdapter != null)
                            arrayAdapter.getFilter().filter(newText);
                        return false;
                    }

                });

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        try {
                            for( int i = 0; i< apiData.length(); i++){
                                if(arrayAdapter.getItem(position).equals(apiData.getJSONObject(i).getString("title"))){
                                    exercise.setName(apiData.getJSONObject(i).getString("title"));
                                    txtName.setText(apiData.getJSONObject(i).getString("title"));
                                    exercise.setMusclePart(apiData.getJSONObject(i).getString("category"));
                                    txtMusclePart.setText(apiData.getJSONObject(i).getString("category"));
                                    txtDescription.setText(apiData.getJSONObject(i).getString("description"));
                                }
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        getActivity().setTitle(getString(R.string.add_exercise_title
                        ));
                        item.collapseActionView();
                    }
                });

                return true;
        }
        return false;
    }
}