//
//  LabelInformation.swift
//  iosApp
//
//  Created by David FIGUERES FORTUNA on 7/7/25.
//

import SwiftUI

struct LabelInformation: View {
    let text: String
    
    var body: some View {
        Text(text).padding(.horizontal,20).padding(.vertical,8)
            .overlay(
                RoundedRectangle(cornerRadius: 12).stroke(Color(.backgroundPrimary), lineWidth:3))
            
    }
}


