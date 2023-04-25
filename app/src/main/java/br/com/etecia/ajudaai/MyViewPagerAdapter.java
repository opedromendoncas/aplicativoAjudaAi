package br.com.etecia.ajudaai;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class MyViewPagerAdapter extends FragmentStateAdapter {


    public MyViewPagerAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new LoginFragment();
            case 1:
                return new CadastroFragment();
            default:
                return new LoginFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
