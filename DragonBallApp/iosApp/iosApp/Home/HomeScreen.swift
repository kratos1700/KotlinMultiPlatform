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
    var homeViewModel = HomeViewModel()
    
    
    
    
    var body: some View {
        Text(/*@START_MENU_TOKEN@*/"Hello, World!"/*@END_MENU_TOKEN@*/)
    }
}

#Preview {
    HomeScreen()
}
