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
            
            NavigationStack {
              VStack {
                  
                  Text("Vegeta Edition").font(.title).bold().foregroundColor(.white)
                  
                  ScrollView {
                      

                      LazyVStack {
                          ForEach(homeViewModel.characters, id:\.self) {character in
                              NavigationLink(destination: {}){
                                  
                                  CharacterItem(item: character)
                                  
                                  
                              }
                              
                             
                              
                          }
                      }
                  
                  
                    
                }

                }.background(Color(.backgroundPrimary))
                
            }
            
            
        }else {
            ProgressView()
        }
    }
}

#Preview {
    HomeScreen()
}
