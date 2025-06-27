//
//  HomeScreen.swift
//  iosApp
//
//  Created by David FIGUERES FORTUNA on 24/6/25.
//

import SwiftUI
import Shared
import KMPObservableViewModelSwiftUI
import KMPNativeCoroutinesAsync


struct HomeScreen: View {
    
    @StateViewModel
    var homeViewModel = HomeViewModel(repository:DiHelper().repository)
    
    
    
    
    var body: some View {
        if  !homeViewModel.characters.isEmpty {
            
            LazyVStack {
                ForEach(homeViewModel.characters, id:\.self) {character in
                    Text(character.name)
                    
                }
            }
        }else {
            Text("Loading...")
        }
    }
}

#Preview {
    HomeScreen()
}
