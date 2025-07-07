//
//  TransformationInfoView.swift
//  iosApp
//
//  Created by David FIGUERES FORTUNA on 7/7/25.
//

import SwiftUI
import Shared
import Kingfisher

struct TransformationInfoView: View {
    
    let transformation:TransformationModel
    
    var body: some View {
        VStack{
            
            KFImage(URL(string: transformation.image))
                .placeholder {
                    ProgressView()
                }.resizable()
                .scaledToFit()
           //     .frame(maxWidth: 100, maxHeight: 150)
            
            Text(transformation.name)
            
        }.padding(.horizontal,24).padding(.vertical,12).cornerRadius(20)
            .shadow(radius: 16)
            .overlay(RoundedRectangle(cornerRadius: 20).stroke(.gray))
    }
}


